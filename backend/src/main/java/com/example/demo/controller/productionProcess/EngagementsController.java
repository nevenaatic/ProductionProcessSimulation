package com.example.demo.controller.productionProcess;

import com.example.demo.dto.engagements.EngagementRequestDto;
import com.example.demo.dto.engagements.EngagementsByEmployeeDto;
import com.example.demo.service.productionProcess.EngagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "engagements")
public class EngagementsController {
    private EngagementService engagementService;

    public EngagementsController(EngagementService engagementService) {
        this.engagementService = engagementService;
    }

    @PostMapping("/")
    @PreAuthorize("hasAnyRole('PRODUCTION_MANAGER','PROCESS_ENGINEER')")
    public ResponseEntity<List<EngagementsByEmployeeDto>> getForEmployee(@RequestBody EngagementRequestDto engagementRequestDto){
        return new ResponseEntity<>(engagementService.getEngagementForPeriod(engagementRequestDto), HttpStatus.OK);
    }
}
