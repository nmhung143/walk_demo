package com.demo.infrastructure.persistence.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Getter
@Setter
@Document
public class StepRealtimeEntity {
    @Id
    private String userId;

    private Long step;
}
