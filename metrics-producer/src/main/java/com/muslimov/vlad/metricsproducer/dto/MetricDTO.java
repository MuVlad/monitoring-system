package com.muslimov.vlad.metricsproducer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetricDTO {

    private String name;
    private String description;
    private String value;
}
