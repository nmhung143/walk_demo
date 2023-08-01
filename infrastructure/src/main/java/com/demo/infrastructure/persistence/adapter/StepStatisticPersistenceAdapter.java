package com.demo.infrastructure.persistence.adapter;

import com.demo.common.BaseAdapter;
import com.demo.common.exception.ErrorCode;
import com.demo.domain.step.StepStatistic;
import com.demo.domain.step.persistence.StepStatisticPersistence;
import com.demo.infrastructure.persistence.mapper.StepStatisticEntityMapper;
import com.demo.infrastructure.persistence.mongo.entity.StepStatisticEntity;
import com.demo.infrastructure.persistence.mongo.repo.StepStatisticEntityRepository;
import org.springframework.stereotype.Component;

@Component
public class StepStatisticPersistenceAdapter
        extends BaseAdapter<StepStatisticEntity, StepStatistic, String>
        implements StepStatisticPersistence {
    protected StepStatisticPersistenceAdapter(StepStatisticEntityMapper mapper,
                                              StepStatisticEntityRepository repo) {
        super(mapper, repo);
    }

    @Override
    protected ErrorCode NotFoundErrorCode() {
        return null;
    }
}
