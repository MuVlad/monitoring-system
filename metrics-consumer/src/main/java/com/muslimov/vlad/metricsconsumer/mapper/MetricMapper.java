package com.muslimov.vlad.metricsconsumer.mapper;

import com.muslimov.vlad.metricsconsumer.dto.MetricDTO;
import com.muslimov.vlad.metricsconsumer.model.MetricEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface MetricMapper {

    MetricEntity toEntity(MetricDTO metricDTO);
    MetricDTO toDto(MetricEntity metricEntity);
}
