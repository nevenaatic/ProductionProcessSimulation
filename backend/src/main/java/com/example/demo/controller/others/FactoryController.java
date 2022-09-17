package com.example.demo.controller.others;

import com.example.demo.dto.others.FactoryDto;
import com.example.demo.model.others.Factory;
import com.example.demo.model.users.User;
import com.example.demo.service.others.FactoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "factory")
public class FactoryController {

    private FactoryService factoryService;

    public FactoryController(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @GetMapping()
    public ResponseEntity<FactoryDto> getFactory(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        FactoryDto factory = new FactoryDto(factoryService.getAll());
        return  new ResponseEntity<>(factory, HttpStatus.OK);
    }
}
