package com.muslimov.vlad.metricsconsumer.exception.model;

public class MetricNotFoundException extends RuntimeException {

    public MetricNotFoundException() {
    }

    public MetricNotFoundException(String message) {
        super(message);
    }
}
