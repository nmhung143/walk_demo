package com.demo.infrastructure.persistence.mongo.repo;

import com.demo.infrastructure.persistence.mongo.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends MongoRepository<UserEntity, String> {
}
