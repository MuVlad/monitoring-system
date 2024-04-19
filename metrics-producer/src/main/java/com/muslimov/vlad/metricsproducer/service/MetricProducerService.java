package com.muslimov.vlad.metricsproducer.service;

import com.muslimov.vlad.metricsproducer.dto.MetricDTO;
import com.muslimov.vlad.metricsproducer.mapper.impl.MetricMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MetricProducerService {

    private final KafkaTemplate<String, MetricDTO> kafkaTemplate;
    private final MetricsEndpoint metricsEndpoint;
    private final MetricMapper metricMapper;

    public void sendMetrics() {
        sendMetric("system.cpu.usage");
        sendMetric("disk.total");
        sendMetric("disk.free");
        sendMetric("jvm.memory.used");
        sendMetric("application.started.time");
    }

    public void sendMetric(String metricName) {
        final MetricsEndpoint.MetricDescriptor metricDescriptor = metricsEndpoint.metric(metricName, null);
        MetricDTO metric = metricMapper.map(metricDescriptor);
        log.info("Sending metric: {} to Kafka.", metric);
        kafkaTemplate.send("metrics-topic", metric);
    }
}
