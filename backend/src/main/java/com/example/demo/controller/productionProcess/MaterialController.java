package com.example.demo.controller.productionProcess;

import com.example.demo.service.productionProcess.MaterialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "materials")
public class MaterialController {
    
    private MaterialService materialService;
    
    public MaterialController(MaterialService materialService){
        this.materialService = materialService;
    }
}
