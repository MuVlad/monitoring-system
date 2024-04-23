package com.muslimov.vlad.metricsproducer.controller;

import com.muslimov.vlad.metricsproducer.BaseIntegrationTest;
import com.muslimov.vlad.metricsproducer.service.MetricProducerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MetricProducerControllerTest extends BaseIntegrationTest {

    @MockBean
    protected MetricProducerService metricProducerService;

    @Test
    @DisplayName("Sending metrics to the server")
    void sendMetrics() throws Exception {

        mockMvc.perform(post("/api/v1/metrics"))
            .andExpect(status().isOk())
            .andExpect(content().string("Metrics has been successfully sent to server kafka."));

        verify(metricProducerService, times(1)).sendMetrics();
    }
}