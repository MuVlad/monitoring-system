package com.muslimov.vlad.metricsconsumer.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "metrics")
public class MetricEntity {

    private static final String SEQ_NAME = "metric_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(
        name = SEQ_NAME,
        sequenceName = SEQ_NAME,
        allocationSize = 1
    )
    private Long id;
    private String name;
    private String description;
    private String value;
}
