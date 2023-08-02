package com.demo.domain.step.persistence;

import com.demo.common.BasePersistence;
import com.demo.common.Page;
import com.demo.common.PageReq;
import com.demo.domain.step.StepRealtime;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
public interface StepRealtimePersistence extends BasePersistence<StepRealtime, String> {
    Page<StepRealtime> getStepRealtimeChart(PageReq req);

    Page<StepRealtime> findAll(PageReq req);
}
