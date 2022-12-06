package com.example.demo.controller.productionProcess;

import com.example.demo.dto.process.ProcessStepKindPreviewDto;
import com.example.demo.model.productionProcess.ProcessStepKind;
import com.example.demo.model.users.User;
import com.example.demo.service.productionProcess.ProcessStepKindService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "process-step-kinds")
public class ProcessStepKindController {

    private ProcessStepKindService processStepKindService;

    public ProcessStepKindController(ProcessStepKindService processStepKindService){
        this.processStepKindService= processStepKindService;
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('PROCESS_ENGINEER', 'QUALITY_ENGINEER')")
    public ResponseEntity<List<ProcessStepKindPreviewDto>> getAll(){
        List<ProcessStepKindPreviewDto> ret = new ArrayList<>();
        for(ProcessStepKind p: this.processStepKindService.getAll() ){
            ret.add(new ProcessStepKindPreviewDto(p));
        }
       return new ResponseEntity<>(ret, HttpStatus.OK);
    }

}
