package com.example.demo.controller.productionProcess;

import com.example.demo.service.productionProcess.StepOfProductionProcessService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= "stepOfProduction")
public class StepOfProductionProcessController {

    private StepOfProductionProcessService stepOfProductionProcessService;

    public StepOfProductionProcessController(StepOfProductionProcessService stepOfProductionProcessService) {
        this.stepOfProductionProcessService = stepOfProductionProcessService;
    }
}
