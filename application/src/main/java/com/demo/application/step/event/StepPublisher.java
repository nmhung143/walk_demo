package com.demo.application.step.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@Component
@RequiredArgsConstructor
public class StepPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public void publishCreateStepEvent(CreateStepEvent event) {
        eventPublisher.publishEvent(event);
    }
}
