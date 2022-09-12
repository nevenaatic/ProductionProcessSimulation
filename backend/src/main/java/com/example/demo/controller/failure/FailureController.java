package com.example.demo.controller.failure;

import com.example.demo.dto.failures.FailuresPreviewDto;
import com.example.demo.model.failure.Failure;
import com.example.demo.model.users.User;
import com.example.demo.service.failure.FailureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "failure")
public class FailureController {

    private FailureService failureService;
    private User loggedUser;

    public FailureController(FailureService failureService){
        this.failureService = failureService;
    }

    @GetMapping("failures")
    public ResponseEntity<List<FailuresPreviewDto>> getAll() {
        List<FailuresPreviewDto> failures = new ArrayList<>();
        this.loggedUser = authenticateMe();
        for (Failure e : this.failureService.getAll()) {
            failures.add(new FailuresPreviewDto(e));
        }
        return new ResponseEntity<>(failures, HttpStatus.OK);
    }

    private User authenticateMe(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return  (User)authentication.getPrincipal();
    }
}
