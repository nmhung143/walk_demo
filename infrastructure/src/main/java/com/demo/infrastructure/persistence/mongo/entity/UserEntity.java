package com.demo.infrastructure.persistence.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Getter
@Setter
@Document
public class UserEntity {
    @Id
    private String id = UUID.randomUUID().toString();
    private String username;
    private String fullName;
    private String password;
}
