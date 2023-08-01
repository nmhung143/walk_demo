package com.demo.infrastructure.persistence.mongo.repo;

import com.demo.domain.step.StepRealTime;
import com.demo.infrastructure.persistence.mongo.entity.StepRealtimeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRealTimeRepository extends MongoRepository<StepRealtimeEntity, String> {
}
