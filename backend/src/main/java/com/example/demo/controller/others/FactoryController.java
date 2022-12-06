package com.example.demo.controller.others;

import com.example.demo.dto.others.FactoryDto;
import com.example.demo.model.others.Factory;
import com.example.demo.model.users.User;
import com.example.demo.service.others.FactoryService;
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

@Controller
@RequestMapping(value = "factory")
public class FactoryController {

    private FactoryService factoryService;

    public FactoryController(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @GetMapping()
    @PreAuthorize("hasAnyRole('PROCESS_ENGINEER', 'ADMIN', 'PRODUCTION_MANAGER', 'QUALITY_ENGINEER')")
    public ResponseEntity<FactoryDto> getFactory(){
        return  new ResponseEntity<>(new FactoryDto(factoryService.getAll()), HttpStatus.OK);
    }

    @PostMapping("/")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<FactoryDto> editFactory(@RequestBody FactoryDto factoryDto){
        return  new ResponseEntity<>(new FactoryDto(factoryService.editFactory(factoryDto)), HttpStatus.OK);
    }

}
