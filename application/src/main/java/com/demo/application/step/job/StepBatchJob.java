package com.demo.application.step.job;

import com.demo.domain.step.usecase.StepRealTimeUseCase;
import com.demo.domain.step.usecase.StepStatisticUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@Component
@RequiredArgsConstructor
public class StepBatchJob {
    private StepStatisticUseCase stepStatisticUseCase;
    private StepRealTimeUseCase stepRealTimeUseCase;

    // Clear data when monday or 1st
    @Scheduled(cron = "0 0 0 * * ?")
    public void dailyBatchJob() {
        calculateWeekStep();
        calculateMonthStep();
        clearRealtimeTable();
    }

    public void clearRealtimeTable() {
        //Todo: clear realtime table logic (Using spring batch with trunks)
    }

    public void calculateWeekStep() {
        var cal = Calendar.getInstance();
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                // Clear week step if monday
        }
        ////Todo: clear realtime table logic (Using spring batch with trunks and parallel processing)
    }

    public void calculateMonthStep() {
        var cal = Calendar.getInstance();
        if (cal.get(Calendar.DAY_OF_MONTH) == 1) {
                // Clear month step if 1st
        }
        ////Todo: clear realtime table logic (Using spring batch with trunks and parallel processing)
    }
}
