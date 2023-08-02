package com.demo.application.step.restful.api;

import com.demo.application.step.facade.StepRealtimeFacade;
import com.demo.application.step.restful.request.UpdateRealtimeStepReq;
import com.demo.application.step.restful.response.RealtimeStepResp;
import com.demo.common.Page;
import com.demo.common.PageReq;
import com.demo.domain.step.StepRealtime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/steps/realtime")
public class StepRealtimeController {
    private final StepRealtimeFacade stepRealtimeFacade;
    @PutMapping
    public void updateRealtimeStep(@RequestBody UpdateRealtimeStepReq req) {
        stepRealtimeFacade.updateStep(req);
    }

    @GetMapping()
    public RealtimeStepResp getRealtimeStep() {
        return stepRealtimeFacade.getRealtimeStep();
    }

    @GetMapping("/chart")
    public Page<StepRealtime> getRealtimeChart(@ModelAttribute PageReq req) {
        return stepRealtimeFacade.getRealtimeChart(req);
    }
}
