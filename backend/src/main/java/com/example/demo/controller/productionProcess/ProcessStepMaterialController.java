package com.example.demo.controller.productionProcess;

import com.example.demo.service.productionProcess.ProcessStepMaterialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "processStepMaterial")
public class ProcessStepMaterialController {

    private ProcessStepMaterialService processStepMaterialService;

    public ProcessStepMaterialController(ProcessStepMaterialService processStepMaterialService) {
        this.processStepMaterialService = processStepMaterialService;
    }
}
