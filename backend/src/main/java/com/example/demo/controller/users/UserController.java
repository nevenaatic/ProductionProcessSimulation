package com.example.demo.controller.users;

import com.example.demo.dto.users.UserProfileInfoDto;
import com.example.demo.model.users.User;
import com.example.demo.service.users.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/userProfile")
    public ResponseEntity<UserProfileInfoDto> getProfileInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        return new ResponseEntity<>(new UserProfileInfoDto(user), HttpStatus.OK);
    }

    @PostMapping("/updateProfile")
    public ResponseEntity<Void> updateProfile(@RequestBody UserProfileInfoDto updatedUser){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        userService.updateProfile(updatedUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
