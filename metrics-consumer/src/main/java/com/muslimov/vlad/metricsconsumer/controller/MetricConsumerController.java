package com.muslimov.vlad.metricsconsumer.controller;

import com.muslimov.vlad.metricsconsumer.dto.MetricDTO;
import com.muslimov.vlad.metricsconsumer.service.MetricConsumerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/metrics")
@Tag(name = "MetricConsumerController", description = "Getting metrics to customers")
public class MetricConsumerController {

    private final MetricConsumerService metricConsumerService;

    @GetMapping
    @Operation(summary = "Getting a list of all metrics")
    public HttpEntity<List<MetricDTO>> getMetrics() {
        return ResponseEntity.ok(metricConsumerService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Getting a specific metric by its identifier")
    public HttpEntity<MetricDTO> getMetric(@RequestParam Long id) {
        return ResponseEntity.ok(metricConsumerService.getById(id));
    }
}
