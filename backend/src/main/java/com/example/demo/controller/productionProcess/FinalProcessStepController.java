package com.example.demo.controller.productionProcess;

import com.example.demo.service.productionProcess.FinalProcessStepService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "final-process-steps")
public class FinalProcessStepController {
    private FinalProcessStepService finalProcessStepService;

    public FinalProcessStepController(FinalProcessStepService finalProcessStepService) {
        this.finalProcessStepService = finalProcessStepService;
    }
}
