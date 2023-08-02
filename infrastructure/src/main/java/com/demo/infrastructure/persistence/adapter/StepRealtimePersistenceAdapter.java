package com.demo.infrastructure.persistence.adapter;

import com.demo.common.BaseAdapter;
import com.demo.common.Page;
import com.demo.common.PageReq;
import com.demo.common.exception.ErrorCode;
import com.demo.domain.step.StepRealtime;
import com.demo.domain.step.persistence.StepRealtimePersistence;
import com.demo.infrastructure.persistence.mapper.StepRealtimeEntityMapper;
import com.demo.infrastructure.persistence.mongo.entity.StepRealtimeEntity;
import com.demo.infrastructure.persistence.mongo.repo.StepRealTimeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Component
public class StepRealtimePersistenceAdapter
        extends BaseAdapter<StepRealtimeEntity, StepRealtime, String>
        implements StepRealtimePersistence {
    protected StepRealtimePersistenceAdapter(StepRealtimeEntityMapper mapper,
                                             StepRealTimeRepository repo) {
        super(mapper, repo);
    }

    @Override
    protected ErrorCode notFoundErrorCode() {
        return null;
    }

    @Override
    public Page<StepRealtime> getStepRealtimeChart(PageReq req) {
        var stepEntities = repo().findAllByOrderByStep(PageRequest.of(req.getPageIndex(), req.getPageSize()));
        var listStep = new ArrayList<StepRealtime>();
        stepEntities.getContent().forEach(stepRealtimeEntity -> listStep.add(mapper.toDomain(stepRealtimeEntity)));
        return new Page<>(listStep,
                req.getPageIndex(),
                req.getPageSize(),
                stepEntities.getTotalElements(),
                stepEntities.getTotalPages());
    }

    @Override
    public Page<StepRealtime> findAll(PageReq req) {
        return new Page<>(repo().findAll(PageRequest.of(req.getPageIndex(), req.getPageSize())).map(mapper()::toDomain));
    }

    @Override
    protected StepRealtimeEntityMapper mapper() {
        return (StepRealtimeEntityMapper) mapper;
    }

    @Override
    protected StepRealTimeRepository repo() {
        return (StepRealTimeRepository) repo;
    }
}
