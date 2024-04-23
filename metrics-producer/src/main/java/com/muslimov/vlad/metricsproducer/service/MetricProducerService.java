package com.muslimov.vlad.metricsproducer.service;

import com.muslimov.vlad.metricsproducer.dto.MetricDTO;
import com.muslimov.vlad.metricsproducer.mapper.impl.MetricMapperImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * Service class responsible for collecting metrics and sending them to Kafka.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MetricProducerService {

    private final KafkaTemplate<String, MetricDTO> kafkaTemplate;
    private final MetricsEndpoint metricsEndpoint;
    private final MetricMapperImpl metricMapperImpl;

    public void sendMetrics() {
        sendMetric("system.cpu.usage");
        sendMetric("disk.total");
        sendMetric("disk.free");
        sendMetric("jvm.memory.used");
        sendMetric("application.started.time");
    }

    /**
     * Sends a specific metric to Kafka.
     * If successful, log metadata of the sent metric
     * If an error occurred, log the error message
     *
     * @param metricName Name of the metric to be sent.
     */
    public void sendMetric(String metricName) {
        final MetricsEndpoint.MetricDescriptor metricDescriptor = metricsEndpoint.metric(metricName, null);
        MetricDTO metric = metricMapperImpl.map(metricDescriptor);

        final CompletableFuture<SendResult<String, MetricDTO>> send = kafkaTemplate.send("metrics-topic", metric);

        send.whenComplete((result, exception) ->
            {
                if (exception == null) {

                    StringBuilder metaData = new StringBuilder();
                    metaData.append("Topic: %s, ".formatted(result.getRecordMetadata().topic()));
                    metaData.append("Partition: %s, ".formatted(result.getRecordMetadata().partition()));
                    metaData.append("Offset: %s, ".formatted(result.getRecordMetadata().offset()));

                    log.info("Sending metric: {} to Kafka. MetaData: {}, ", metric, metaData);

                } else {
                    log.info("Error sending metric: {} to Kafka.", metric, exception);
                }
            }
        );
    }
}
