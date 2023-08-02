package com.demo.infrastructure.persistence.mongo.repo;

import com.demo.infrastructure.persistence.mongo.entity.StepRealtimeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Repository
public interface StepRealTimeRepository extends MongoRepository<StepRealtimeEntity, String> {
    Page<StepRealtimeEntity> findAllByOrderByStep(PageRequest pageRequest);
}
