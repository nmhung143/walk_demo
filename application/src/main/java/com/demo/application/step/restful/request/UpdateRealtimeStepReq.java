package com.demo.application.step.restful.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateRealtimeStepReq {
    private Long step;
}
