package com.example.demo.controller.productionProcess;

import com.example.demo.dto.process.FinalProductionProcessDto;
import com.example.demo.model.productionProcess.FinalProductionProcess;
import com.example.demo.model.users.User;
import com.example.demo.service.productionProcess.FinalProductionProcessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = "finalProductionProcess")
public class FinalProductionProcessController {
    private FinalProductionProcessService finalProductionProcessService;

    public FinalProductionProcessController(FinalProductionProcessService finalProductionProcessService) {
        this.finalProductionProcessService = finalProductionProcessService;
    }

    @PostMapping(value = "startProcess")
    public ResponseEntity<HttpStatus> startProcess(@RequestBody int id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        finalProductionProcessService.startProcess(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "startFailedProcess")
    public ResponseEntity<HttpStatus> startFailedProcess(@RequestBody int id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        finalProductionProcessService.startFailureProcess(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("processes")
    public ResponseEntity<List<FinalProductionProcessDto>> getAll(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        List<FinalProductionProcessDto> ret = new ArrayList<>();
        Random rand = new Random();
//        for(FinalProductionProcess f : this.finalProductionProcessService.getFinalProcesses()){
//            double time = Math.round((10.0 + (28 - 10.0) * rand.nextDouble()) * 10.0) / 10.0;
//            ret.add(new FinalProductionProcessDto(f, time));
//        }


        return  new ResponseEntity<>(this.finalProductionProcessService.processWithFailureInformation(), HttpStatus.OK);
    }
}
