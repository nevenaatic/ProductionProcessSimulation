package com.example.demo.controller.productionProcess;

import com.example.demo.dto.process.FinalProductionProcessDto;
import com.example.demo.dto.report.ExecutionProcessInformationDto;
import com.example.demo.model.productionProcess.FinalProductionProcess;
import com.example.demo.model.users.User;
import com.example.demo.service.productionProcess.FinalProductionProcessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(value = "final-production-processes")
public class FinalProductionProcessController {
    private FinalProductionProcessService finalProductionProcessService;

    public FinalProductionProcessController(FinalProductionProcessService finalProductionProcessService) {
        this.finalProductionProcessService = finalProductionProcessService;
    }

    @PostMapping(value = "start-process")
    @PreAuthorize("hasAnyRole('PROCESS_ENGINEER')")
    public ResponseEntity<HttpStatus> startProcess(@RequestBody int id){
        finalProductionProcessService.startProcess(id, authenticateMe().getId());
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "start-failed-process")
    @PreAuthorize("hasAnyRole('PROCESS_ENGINEER')")
    public ResponseEntity<HttpStatus> startFailedProcess(@RequestBody int id){
        finalProductionProcessService.startFailureProcess(id, authenticateMe().getId());
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('PROCESS_ENGINEER')")
    public ResponseEntity<List<FinalProductionProcessDto>> getAll(){
        return  new ResponseEntity<>(this.finalProductionProcessService.processWithFailureInformation(), HttpStatus.OK);
    }

    @PostMapping("report")
    @PreAuthorize("hasAnyRole('PROCESS_ENGINEER')")
    public ResponseEntity<ExecutionProcessInformationDto> executionReport(@RequestBody int id){
        return new ResponseEntity<>(this.finalProductionProcessService.completeInformationFromExecution(id),HttpStatus.OK);
    }

    private User authenticateMe(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User)authentication.getPrincipal();
    }
}
