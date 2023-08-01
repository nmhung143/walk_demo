package com.demo.infrastructure.persistence.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class StepStatisticEntity {
    @Id
    private String userId;
    private Long weekStep;
    private Long monthStep;
}
