package com.demo.application.step.service;

import com.demo.common.BaseApplicationService;
import com.demo.common.Page;
import com.demo.common.PageReq;
import com.demo.domain.step.StepStatistic;
import com.demo.domain.step.persistence.StepStatisticPersistence;
import com.demo.domain.step.usecase.StepStatisticUseCase;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@Service
public class StepStatisticService
        extends BaseApplicationService<StepStatistic, String, StepStatisticPersistence>
        implements StepStatisticUseCase {
    public StepStatisticService(StepStatisticPersistence repo) {
        super(repo);
    }

    @Override
    public Page<StepStatistic> findAll(PageReq req) {
        return repo.findAll(req);
    }
}
