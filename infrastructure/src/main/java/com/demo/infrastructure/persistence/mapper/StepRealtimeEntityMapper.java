package com.demo.infrastructure.persistence.mapper;

import com.demo.common.BaseMapper;
import com.demo.domain.step.StepRealtime;
import com.demo.infrastructure.persistence.mongo.entity.StepRealtimeEntity;
import org.mapstruct.Mapper;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Mapper
public interface StepRealtimeEntityMapper extends BaseMapper<StepRealtimeEntity, StepRealtime> {
}
