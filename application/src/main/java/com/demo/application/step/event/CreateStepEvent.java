package com.demo.application.step.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStepEvent {
    private String userId;
    private Long realtimeStep;
}
