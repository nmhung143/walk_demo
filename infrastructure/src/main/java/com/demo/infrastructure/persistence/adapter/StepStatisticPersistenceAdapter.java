package com.demo.infrastructure.persistence.adapter;

import com.demo.common.BaseAdapter;
import com.demo.common.Page;
import com.demo.common.PageReq;
import com.demo.common.exception.ErrorCode;
import com.demo.domain.step.StepStatistic;
import com.demo.domain.step.persistence.StepStatisticPersistence;
import com.demo.infrastructure.persistence.mapper.StepStatisticEntityMapper;
import com.demo.infrastructure.persistence.mongo.entity.StepStatisticEntity;
import com.demo.infrastructure.persistence.mongo.repo.StepStatisticEntityRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Component
@SuppressWarnings("ALL")
public class StepStatisticPersistenceAdapter
        extends BaseAdapter<StepStatisticEntity, StepStatistic, String>
        implements StepStatisticPersistence {
    protected StepStatisticPersistenceAdapter(StepStatisticEntityMapper mapper,
                                              StepStatisticEntityRepository repo) {
        super(mapper, repo);
    }

    @Override
    protected ErrorCode notFoundErrorCode() {
        return null;
    }

    @Override
    public Page<StepStatistic> findAll(PageReq req) {
        return new Page(repo().findAll(PageRequest.of(req.getPageIndex(), req.getPageSize())).map(mapper()::toDomain));
    }
}
