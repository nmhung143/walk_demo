package com.demo.application.step.facade;

import com.demo.application.security.SecurityContext;
import com.demo.application.step.event.CreateStepEvent;
import com.demo.application.step.restful.response.MonthStepResp;
import com.demo.application.step.restful.response.WeekStepResp;
import com.demo.domain.step.StepRealtime;
import com.demo.domain.step.StepStatistic;
import com.demo.domain.step.usecase.StepStatisticUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@Component
@RequiredArgsConstructor
public class StepStatisticFacade {
    private final StepStatisticUseCase stepStatisticUseCase;
    private final SecurityContext securityContext;

    public WeekStepResp getWeekStep() {
        var userId = securityContext.getUserId();
        var stepStatistic = stepStatisticUseCase.findById(userId);
        return new WeekStepResp(stepStatistic.getWeekStep());
    }

    public MonthStepResp getMonthStep() {
        var userId = securityContext.getUserId();
        var stepStatistic = stepStatisticUseCase.findById(userId);
        return new MonthStepResp(stepStatistic.getMonthStep());
    }

    public void createStatisticStep(CreateStepEvent event) {
        var stepStatistic = new StepStatistic();
        stepStatistic.setUserId(event.getUserId());
        stepStatistic.setMonthStep(0L);
        stepStatistic.setWeekStep(0L);
        stepStatisticUseCase.save(stepStatistic);
    }
}
