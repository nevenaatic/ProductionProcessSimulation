package com.example.demo.controller.users;

import com.example.demo.dto.users.EmployeePreviewDto;
import com.example.demo.model.users.Employee;
import com.example.demo.model.users.User;
import com.example.demo.service.users.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value = "employee")
public class EmployeeController {

    private EmployeeService employeeService;
    private User loggedUser;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    @GetMapping("employees")
    public ResponseEntity<List<EmployeePreviewDto>> getAll() {
        List<EmployeePreviewDto> employees = new ArrayList<>();
        this.loggedUser = authenticateMe();
        for (Employee e : this.employeeService.getAll()) {
            employees.add(new EmployeePreviewDto(e));
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    private User authenticateMe(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return  (User)authentication.getPrincipal();
    }
}
