package com.muslimov.vlad.metricsconsumer.service;

import com.muslimov.vlad.metricsconsumer.dto.MetricDTO;

import java.util.List;

public interface MetricConsumerService {

    List<MetricDTO> getAll();
    MetricDTO getById(Long id);
    void save(MetricDTO metricDTO);
}
