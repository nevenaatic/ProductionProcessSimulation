package com.example.demo.controller.productionProcess;

import com.example.demo.service.productionProcess.ProcessStepService;
import org.springframework.stereotype.Controller;

@Controller
public class ProcessStepController {

    private ProcessStepService processStepService;

    public ProcessStepController(ProcessStepService processStepService){
        this.processStepService= processStepService;
    }

}
