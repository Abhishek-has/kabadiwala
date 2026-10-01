package com.user.authservice.controller;

import com.user.authservice.dao.Users;
import com.user.authservice.dto.UsersResistrationDTO;
import com.user.authservice.services.UsersResistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserResistrationController {
  private final UsersResistrationService usersResistrationService;

    public UserResistrationController(UsersResistrationService usersResistrationService) {
        this.usersResistrationService = usersResistrationService;
    }

    @PostMapping("/resisteredUser")
    public ResponseEntity<?> registerUser( @RequestBody UsersResistrationDTO request) {
        Users registeredUser = usersResistrationService.addUser(request);

        return new ResponseEntity<>(Map.of(
                "message", "User registered successfully!",
                "userId", registeredUser.getId(),
                "username", registeredUser.getUserName()
        ), HttpStatus.CREATED);
    }
}
