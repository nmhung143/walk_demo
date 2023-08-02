package com.demo.application.step.service;

import com.demo.common.BaseApplicationService;
import com.demo.common.Page;
import com.demo.common.PageReq;
import com.demo.domain.step.StepRealtime;
import com.demo.domain.step.persistence.StepRealtimePersistence;
import com.demo.domain.step.usecase.StepRealTimeUseCase;
import org.springframework.stereotype.Service;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@Service
public class StepRealtimeService
        extends BaseApplicationService<StepRealtime, String, StepRealtimePersistence>
        implements StepRealTimeUseCase {
    public StepRealtimeService(StepRealtimePersistence repo) {
        super(repo);
    }

    @Override
    public Page<StepRealtime> getStepRealtimeChart(PageReq req) {
        return repo.getStepRealtimeChart(req);
    }

    @Override
    public Page<StepRealtime> findAll(PageReq req) {
        return repo.findAll(req);
    }
}
