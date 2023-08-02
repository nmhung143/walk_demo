package com.demo.domain.step.persistence;

import com.demo.common.BasePersistence;
import com.demo.common.Page;
import com.demo.common.PageReq;
import com.demo.domain.step.StepStatistic;
import org.springframework.data.domain.Slice;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
public interface StepStatisticPersistence extends BasePersistence<StepStatistic, String> {
    Page<StepStatistic> findAll(PageReq req);
}
