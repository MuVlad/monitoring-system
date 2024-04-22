package com.muslimov.vlad.metricsconsumer.service.impl;

import com.muslimov.vlad.metricsconsumer.dto.MetricDTO;
import com.muslimov.vlad.metricsconsumer.mapper.MetricMapper;
import com.muslimov.vlad.metricsconsumer.repository.MetricRepository;
import com.muslimov.vlad.metricsconsumer.service.MetricConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetricConsumerServiceImpl implements MetricConsumerService {

    private final MetricRepository metricRepository;
    private final MetricMapper metricMapper;


    public List<MetricDTO> getAll() {
        return metricRepository.findAll()
            .stream()
            .map(metricMapper::toDto)
            .toList();
    }

    public MetricDTO getById(Long id) {
        return metricMapper.toDto(metricRepository.findByIdOrThrow(id));
    }

    @Transactional
    public void save(MetricDTO metricDTO) {
        metricRepository.save(metricMapper.toEntity(metricDTO));
    }
}
