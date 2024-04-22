package com.muslimov.vlad.metricsconsumer.repository;

import com.muslimov.vlad.metricsconsumer.exception.model.MetricNotFoundException;
import com.muslimov.vlad.metricsconsumer.model.MetricEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricRepository extends JpaRepository<MetricEntity, Long> {

    default MetricEntity findByIdOrThrow(long id) {
        return findById(id).orElseThrow(
            () -> new MetricNotFoundException("Metric with id: " + id + " not found")
        );
    }
}
