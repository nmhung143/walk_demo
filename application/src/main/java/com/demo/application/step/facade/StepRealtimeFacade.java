package com.demo.application.step.facade;

import com.demo.application.security.SecurityContext;
import com.demo.application.step.event.CreateStepEvent;
import com.demo.application.step.event.StepPublisher;
import com.demo.application.step.restful.request.UpdateRealtimeStepReq;
import com.demo.application.step.restful.response.RealtimeStepResp;
import com.demo.common.Page;
import com.demo.common.PageReq;
import com.demo.domain.step.StepRealtime;
import com.demo.domain.step.usecase.StepRealTimeUseCase;
import com.demo.domain.step.usecase.StepStatisticUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@Component
@RequiredArgsConstructor
public class StepRealtimeFacade {
    private final StepPublisher stepPublisher;
    private final StepRealTimeUseCase stepRealTimeUseCase;
    private final SecurityContext securityContext;

    public void updateStep(UpdateRealtimeStepReq req) {
        var userId = securityContext.getUserId();
        var stepRealtime = stepRealTimeUseCase.findByIdOpt(userId);
        if (stepRealtime.isEmpty()) { // Create new record if not exists
            stepPublisher.publishCreateStepEvent(new CreateStepEvent(userId, req.getStep()));
            return;
        }
        stepRealtime.get().setStep(req.getStep());
        stepRealTimeUseCase.save(stepRealtime.get());
    }

    public RealtimeStepResp getRealtimeStep() {
        var userId = securityContext.getUserId();
        var stepRealtime = stepRealTimeUseCase.findById(userId);
        return new RealtimeStepResp(stepRealtime.getStep());
    }

    public Page<StepRealtime> getRealtimeChart(PageReq req) {
        return stepRealTimeUseCase.getStepRealtimeChart(req);
    }

    public void createRealtimeStep(CreateStepEvent event) {
        var stepRealtime = new StepRealtime();
        stepRealtime.setUserId(event.getUserId());
        stepRealtime.setStep(event.getRealtimeStep());
        stepRealTimeUseCase.save(stepRealtime);
    }
}
