package com.muslimov.vlad.metricsconsumer.mapper;

import com.muslimov.vlad.metricsconsumer.dto.MetricDTO;
import com.muslimov.vlad.metricsconsumer.model.MetricEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface MetricMapper {

    MetricEntity toEntity(MetricDTO metricDTO);

    MetricDTO toDto(MetricEntity metricEntity);
}
