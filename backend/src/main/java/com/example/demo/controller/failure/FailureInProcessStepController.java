package com.example.demo.controller.failure;

import com.example.demo.dto.failures.FailuresPreviewDto;
import com.example.demo.model.users.User;
import com.example.demo.service.failure.FailureInProcessStepService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="step-failures")
public class FailureInProcessStepController {

    private FailureInProcessStepService failureIPSService;

    public FailureInProcessStepController(FailureInProcessStepService failureIPSService) {
        this.failureIPSService = failureIPSService;
    }

    @PostMapping("/")
    @PreAuthorize("hasAnyRole('QUALITY_ENGINEER')")
    public ResponseEntity<HttpStatus> addNewFailure(@RequestBody FailuresPreviewDto failure) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user=  (User)authentication.getPrincipal();
        this.failureIPSService.addFailureInPS(failure, user.getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
