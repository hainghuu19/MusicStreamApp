package com.springboot.streammusic.controller;


import com.springboot.streammusic.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestParam String user_name, @RequestParam String password) {
        return authService.loginUser(user_name, password);
    }

    @PostMapping("/register")
    public String register(@RequestParam String user_name, @RequestParam  String email, @RequestParam String password){
         authService.registerUser(user_name, email, password);
         return "Register Successful";
    }

}
