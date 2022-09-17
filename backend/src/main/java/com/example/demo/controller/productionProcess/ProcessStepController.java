package com.example.demo.controller.productionProcess;

import com.example.demo.dto.process.ProcessStepDto;
import com.example.demo.model.productionProcess.ProcessStep;
import com.example.demo.service.productionProcess.ProcessStepService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "processStep")
public class ProcessStepController {

    private ProcessStepService processStepService;

    public ProcessStepController(ProcessStepService processStepService){
        this.processStepService= processStepService;
    }


    @GetMapping(value="steps")
    public ResponseEntity<List<ProcessStepDto>> getAll(){
        List<ProcessStepDto> ret = new ArrayList<>();
        for(ProcessStep ps: processStepService.getAll()){
            ret.add(new ProcessStepDto(ps));
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

}
