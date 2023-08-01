package com.demo.infrastructure.persistence.mapper;

import com.demo.common.BaseMapper;
import com.demo.domain.step.StepRealTime;
import com.demo.infrastructure.persistence.mongo.entity.StepRealtimeEntity;
import org.mapstruct.Mapper;

@Mapper
public interface StepRealtimeEntityMapper extends BaseMapper<StepRealtimeEntity, StepRealTime> {
}
