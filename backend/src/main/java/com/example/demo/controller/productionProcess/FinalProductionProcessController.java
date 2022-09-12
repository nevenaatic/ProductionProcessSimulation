package com.example.demo.controller.productionProcess;

import com.example.demo.service.productionProcess.FinalProductionProcessService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "finalProductionProcess")
public class FinalProductionProcessController {
    private FinalProductionProcessService finalProductionProcessService;

    public FinalProductionProcessController(FinalProductionProcessService finalProductionProcessService) {
        this.finalProductionProcessService = finalProductionProcessService;
    }
}
