package com.muslimov.vlad.metricsproducer.mapper.impl;

import com.muslimov.vlad.metricsproducer.dto.MetricDTO;
import com.muslimov.vlad.metricsproducer.mapper.Mapper;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Component;

@Component
public class MetricMapperImpl implements Mapper<MetricsEndpoint.MetricDescriptor, MetricDTO> {
    @Override
    public MetricDTO map(MetricsEndpoint.MetricDescriptor metricDescriptor) {
        return new MetricDTO(
            metricDescriptor.getName(),
            metricDescriptor.getDescription(),
            metricDescriptor.getMeasurements().get(0).getValue().toString()
        );
    }
}
