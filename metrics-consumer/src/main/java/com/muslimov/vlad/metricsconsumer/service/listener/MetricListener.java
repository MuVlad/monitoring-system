package com.muslimov.vlad.metricsconsumer.service.listener;

import com.muslimov.vlad.metricsconsumer.dto.MetricDTO;
import com.muslimov.vlad.metricsconsumer.service.MetricConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MetricListener {

    private final MetricConsumerService metricConsumerService;

    @KafkaListener(id = "metrics-consumer-group", topics = "metrics-topic")
    public void listen(MetricDTO metricDTO) {
        log.info("Received metric {}", metricDTO);
        metricConsumerService.save(metricDTO);
    }

    @KafkaListener(id = "metrics-consumer-group-DLT", topics = "metrics-topic.DLT")
    public void listenDlt(MetricDTO metricDTO) {
        log.info("Received metric in DLT: {}", metricDTO);
    }
}