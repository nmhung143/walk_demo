package com.demo.application.step.event;

import com.demo.application.step.facade.StepRealtimeFacade;
import com.demo.application.step.facade.StepStatisticFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@Component
@RequiredArgsConstructor
public class StepListener {
    private final StepRealtimeFacade stepRealtimeFacade;
    private final StepStatisticFacade stepStatisticFacade;

    @Async
    @EventListener
    void handleCreateStepEvent(CreateStepEvent event) {
        stepRealtimeFacade.createRealtimeStep(event);
        stepStatisticFacade.createStatisticStep(event);
    }
}
