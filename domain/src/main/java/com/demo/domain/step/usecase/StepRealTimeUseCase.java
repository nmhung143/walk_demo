package com.demo.domain.step.usecase;

import com.demo.common.BaseUseCase;
import com.demo.common.Page;
import com.demo.common.PageReq;
import com.demo.domain.step.StepRealtime;
import org.springframework.data.domain.Slice;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
public interface StepRealTimeUseCase extends BaseUseCase<StepRealtime, String> {
    Page<StepRealtime> getStepRealtimeChart(PageReq req);
    Page<StepRealtime> findAll(PageReq req);
}
