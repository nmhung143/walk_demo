package com.demo.domain.step.usecase;

import com.demo.common.BaseUseCase;
import com.demo.common.Page;
import com.demo.common.PageReq;
import com.demo.domain.step.StepStatistic;
import org.springframework.data.domain.Slice;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
public interface StepStatisticUseCase extends BaseUseCase<StepStatistic, String> {
    Page<StepStatistic> findAll(PageReq req);
}
