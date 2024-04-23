package com.muslimov.vlad.metricsconsumer.service.listener;

import com.muslimov.vlad.metricsconsumer.dto.MetricDTO;
import com.muslimov.vlad.metricsconsumer.service.MetricConsumerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@SpringBootTest(classes = MetricListener.class)
class MetricListenerTest {

    @MockBean
    public MetricConsumerService metricConsumerService;

    @Autowired
    public MetricListener metricListener;

    @Test
    public void shouldCallSaveMethodWhenMessageReceived() {
        final MetricDTO metricDTO = new MetricDTO();

        metricListener.listen(metricDTO);

        verify(metricConsumerService).save(metricDTO);
    }

    @Test
    public void shouldLogMessageInDltButNotCallSaveMethod() {
        final MetricDTO metricDTO = new MetricDTO();

        metricListener.listenDlt(metricDTO);

        verify(metricConsumerService, never()).save(any());
    }
}