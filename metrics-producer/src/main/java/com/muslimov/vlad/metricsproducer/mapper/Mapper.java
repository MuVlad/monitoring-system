package com.muslimov.vlad.metricsproducer.mapper;

public interface Mapper<ACTUAL, EXPECTED> {
    EXPECTED map(ACTUAL actual);
}
