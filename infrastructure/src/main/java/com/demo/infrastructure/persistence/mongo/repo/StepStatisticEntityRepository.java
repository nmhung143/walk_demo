package com.demo.infrastructure.persistence.mongo.repo;

import com.demo.infrastructure.persistence.mongo.entity.StepStatisticEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepStatisticEntityRepository extends MongoRepository<StepStatisticEntity, String> {
}
