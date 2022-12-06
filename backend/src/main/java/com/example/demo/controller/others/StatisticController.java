package com.example.demo.controller.others;

import com.example.demo.service.others.StatisticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("statistics")
public class StatisticController {

    private StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("processes")
    @PreAuthorize("hasAnyRole('PRODUCTION_MANAGER')")
    public ResponseEntity<List<String>> getProcessNames(){
        return  new ResponseEntity<>(statisticService.getProcessNames(), HttpStatus.OK);
    }
}
