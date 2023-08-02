package com.demo.application.step.restful.api;

import com.demo.application.step.facade.StepStatisticFacade;
import com.demo.application.step.restful.response.MonthStepResp;
import com.demo.application.step.restful.response.WeekStepResp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/steps/statistic")
public class StepStatisticController {
    private final StepStatisticFacade stepStatisticFacade;
    @GetMapping("/week")
    public WeekStepResp getWeekStep() {
        return stepStatisticFacade.getWeekStep();
    }

    @GetMapping("/month")
    public MonthStepResp getMonthStep() {
        return stepStatisticFacade.getMonthStep();
    }
}
