package com.example.demo.controller.users;

import com.example.demo.dto.users.UserPasswordDto;
import com.example.demo.dto.users.UserProfileInfoDto;
import com.example.demo.dto.users.UserTokenState;
import com.example.demo.model.users.User;
import com.example.demo.service.users.UserService;
import com.example.demo.utils.TokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "users")
public class UserController {

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private TokenUtils tokenUtils;

    public UserController(UserService userService, AuthenticationManager authenticationManager, TokenUtils tokenUtils){
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenUtils = tokenUtils;
    }

    @GetMapping("/profile-info")
    @PreAuthorize("hasAnyRole('PROCESS_ENGINEER', 'ADMIN','QUALITY_ENGINEER','PRODUCTION_MANAGER')")
    public ResponseEntity<UserProfileInfoDto> getProfileInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        return new ResponseEntity<>(new UserProfileInfoDto(user), HttpStatus.OK);
    }

    @PutMapping("/")
    @PreAuthorize("hasAnyRole('PROCESS_ENGINEER', 'ADMIN','QUALITY_ENGINEER','PRODUCTION_MANAGER')")
    public ResponseEntity<Void> updateProfile(@RequestBody UserProfileInfoDto updatedUser){
        userService.updateProfile(updatedUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/password")
    @PreAuthorize("hasAnyRole('PROCESS_ENGINEER', 'ADMIN','QUALITY_ENGINEER','PRODUCTION_MANAGER')")
    public ResponseEntity<UserTokenState> changePassword(@RequestBody UserPasswordDto passwordDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        userService.updatePassword(passwordDto, user);

        Authentication authenticationNew = null;
        try {
            authenticationNew = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getEmail(), passwordDto.password));
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        SecurityContextHolder.getContext().setAuthentication(authenticationNew);
        User userAuth = (User) authenticationNew.getPrincipal();
        String jwt = tokenUtils.generateToken(userAuth.getEmail());
        int expiresIn = tokenUtils.getExpiredIn();

        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn, userAuth.getRole().getName(), user.isEnabled()));
    }

    @PostMapping("/check-password")
    @PreAuthorize("hasAnyRole('PROCESS_ENGINEER', 'ADMIN','QUALITY_ENGINEER','PRODUCTION_MANAGER')")
    public ResponseEntity<HttpStatus> checkPassword(@RequestBody String password){
        //TODO: implement this method
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<HttpStatus> newUser(@RequestBody UserProfileInfoDto employee){
       this.userService.createNewUser(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
