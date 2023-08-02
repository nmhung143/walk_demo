package com.demo.domain.step;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Getter
@Setter
public class StepStatistic {
    private String userId;
    private Long weekStep;
    private Long monthStep;
}
