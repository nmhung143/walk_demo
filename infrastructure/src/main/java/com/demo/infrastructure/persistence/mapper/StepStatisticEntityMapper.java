package com.demo.infrastructure.persistence.mapper;

import com.demo.common.BaseMapper;
import com.demo.domain.step.StepStatistic;
import com.demo.infrastructure.persistence.mongo.entity.StepStatisticEntity;
import org.mapstruct.Mapper;

@Mapper
public interface StepStatisticEntityMapper extends BaseMapper<StepStatisticEntity, StepStatistic> {
}
