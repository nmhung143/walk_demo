package com.demo.infrastructure.persistence.mongo.repo;

import com.demo.infrastructure.persistence.mongo.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Repository
public interface UserEntityRepository extends MongoRepository<UserEntity, String> {
    Optional<UserEntity> findUserEntityByUsername(String username);
}
