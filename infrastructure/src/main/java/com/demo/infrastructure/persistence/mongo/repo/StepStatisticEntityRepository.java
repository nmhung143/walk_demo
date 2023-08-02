package com.demo.infrastructure.persistence.mongo.repo;

import com.demo.infrastructure.persistence.mongo.entity.StepStatisticEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Repository
public interface StepStatisticEntityRepository extends MongoRepository<StepStatisticEntity, String> {
    Slice<StepStatisticEntity> findAll(PageRequest pageRequest);
}
