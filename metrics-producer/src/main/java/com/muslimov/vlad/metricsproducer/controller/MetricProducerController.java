package com.muslimov.vlad.metricsproducer.controller;

import com.muslimov.vlad.metricsproducer.service.MetricProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/metrics")
@RequiredArgsConstructor
@Tag(name = "MetricProducerController", description = "Sending metrics to the server")
public class MetricProducerController {

    private final MetricProducerService metricProducerService;

    @PostMapping
    @Operation(summary = "Sending metrics to the server")
    public HttpEntity<String> sendMetrics() {
        metricProducerService.sendMetrics();
        return ResponseEntity.ok("Metrics has been successfully sent to server kafka.");
    }
}
