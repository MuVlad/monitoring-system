package com.muslimov.vlad.metricsconsumer.controller;

import com.muslimov.vlad.metricsconsumer.model.MetricEntity;
import com.muslimov.vlad.metricsconsumer.support.BaseIntegrationTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class MetricConsumerControllerTest extends BaseIntegrationTest {

    @AfterEach
    public void resetDB() {
        metricRepository.deleteAll();
    }

    @Test
    @DisplayName("Getting a list of all metrics")
    void getMetrics() throws Exception {
        final var metric = savingMetricToDB("Test Metric");
        final var metric1 = savingMetricToDB("Other Metric");

        mockMvc.perform(get("/api/v1/metrics"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].name").value(metric.getName()))
            .andExpect(jsonPath("$[1].name").value(metric1.getName()));


    }

    @Test
    @DisplayName("Getting a specific metric by its identifier")
    void getMetric() throws Exception {
        final var metric = savingMetricToDB("Test Metric");


        mockMvc.perform(get("/api/v1/metrics/" + metric.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value(metric.getName()))
            .andExpect(jsonPath("$.description").value(metric.getDescription()))
            .andExpect(jsonPath("$.value").value(metric.getValue()));

    }

    private MetricEntity savingMetricToDB(String name) {
        return metricRepository.save(
            MetricEntity.builder()
                .name(name)
                .description("Test description")
                .value("Test value")
                .build()
        );
    }
}