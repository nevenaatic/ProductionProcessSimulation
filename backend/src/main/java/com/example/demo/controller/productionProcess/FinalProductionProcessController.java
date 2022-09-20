package com.example.demo.controller.productionProcess;

import com.example.demo.model.users.User;
import com.example.demo.service.productionProcess.FinalProductionProcessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "finalProductionProcess")
public class FinalProductionProcessController {
    private FinalProductionProcessService finalProductionProcessService;

    public FinalProductionProcessController(FinalProductionProcessService finalProductionProcessService) {
        this.finalProductionProcessService = finalProductionProcessService;
    }

    @PostMapping(value = "startProcess")
    public ResponseEntity<HttpStatus> startProcess(int id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        finalProductionProcessService.startProcess(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
