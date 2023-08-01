package com.demo.infrastructure.persistence.adapter;

import com.demo.common.BaseAdapter;
import com.demo.common.exception.ErrorCode;
import com.demo.domain.step.StepRealTime;
import com.demo.domain.step.persistence.StepRealTimePersistence;
import com.demo.infrastructure.persistence.mapper.StepRealtimeEntityMapper;
import com.demo.infrastructure.persistence.mongo.entity.StepRealtimeEntity;
import com.demo.infrastructure.persistence.mongo.repo.StepRealTimeRepository;
import org.springframework.stereotype.Component;

@Component
public class StepRealTimePersistenceAdapter
        extends BaseAdapter<StepRealtimeEntity, StepRealTime, String>
        implements StepRealTimePersistence {
    protected StepRealTimePersistenceAdapter(StepRealtimeEntityMapper mapper,
                                             StepRealTimeRepository repo) {
        super(mapper, repo);
    }

    @Override
    protected ErrorCode NotFoundErrorCode() {
        return null;
    }
}
