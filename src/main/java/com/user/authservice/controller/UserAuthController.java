package com.user.authservice.controller;

import com.user.authservice.dao.Users;
import com.user.authservice.services.UserLoginService;
import com.user.authservice.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserAuthController {

//    private final UserLoginService userLoginService;
//
//    public UserLoginController(UserLoginService userLoginService) {
//        this.userLoginService = userLoginService;
//    }

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtService;
    @Autowired
    private UserLoginService userLoginService;

    public UserAuthController(AuthenticationManager authenticationManager, JwtUtil jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String userName,@RequestParam String password){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName,password)
        );
        return jwtService.generateToken(userName);
        //        Users user=userLoginService.loginUser(userName,password);
//        return ResponseEntity.ok(user);


    }

    @GetMapping("/login/details")
    public ResponseEntity<Users> loginUserDetails(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
                Users user=userLoginService.loginUser(userName);
        return ResponseEntity.ok(user);


    }


}
