package com.example.demo.controller.productionProcess;

import com.example.demo.dto.process.NewProcessForCreateDto;
import com.example.demo.model.productionProcess.ProductionProcess;
import com.example.demo.model.users.User;
import com.example.demo.service.productionProcess.ProductionProcessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "productionProcess")
public class ProductionProcessController {

    private ProductionProcessService productionProcessService;

    public ProductionProcessController(ProductionProcessService productionProcessService) {
        this.productionProcessService = productionProcessService;
    }

    @PostMapping(value="/process")
    public ResponseEntity<HttpStatus> createProcess(@RequestBody NewProcessForCreateDto newProcess){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        productionProcessService.createProcess(newProcess, user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
