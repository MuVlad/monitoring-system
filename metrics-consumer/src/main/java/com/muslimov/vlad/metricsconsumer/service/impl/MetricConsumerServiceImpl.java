package com.muslimov.vlad.metricsconsumer.service.impl;

import com.muslimov.vlad.metricsconsumer.dto.MetricDTO;
import com.muslimov.vlad.metricsconsumer.mapper.MetricMapper;
import com.muslimov.vlad.metricsconsumer.repository.MetricRepository;
import com.muslimov.vlad.metricsconsumer.service.MetricConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of the {@link MetricConsumerService} interface responsible for handling metric data.
 */
@Service
@RequiredArgsConstructor
public class MetricConsumerServiceImpl implements MetricConsumerService {

    private final MetricRepository metricRepository;
    private final MetricMapper metricMapper;

    /**
     * Retrieves all metrics from the database and maps them to DTOs.
     *
     * @return List of MetricDTOs containing all metrics.
     */
    public List<MetricDTO> getAll() {
        return metricRepository.findAll()
            .stream()
            .map(metricMapper::toDto)
            .toList();
    }

    /**
     * Retrieves a specific metric by its ID from the database and maps it to DTO.
     *
     * @param id The ID of the metric to retrieve.
     * @return The MetricDTO corresponding to the specified ID.
     */
    public MetricDTO getById(Long id) {
        return metricMapper.toDto(metricRepository.findByIdOrThrow(id));
    }

    /**
     * Saves the received metric DTO to the database.
     *
     * @param metricDTO The metric to saving.
     */
    @Transactional
    public void save(MetricDTO metricDTO) {
        metricRepository.save(metricMapper.toEntity(metricDTO));
    }
}
