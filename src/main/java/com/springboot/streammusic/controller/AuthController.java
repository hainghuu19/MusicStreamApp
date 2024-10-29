package com.springboot.streammusic.controller;


import com.springboot.streammusic.service.AuthService;
import com.springboot.streammusic.service.TokenBlaclistService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    private final TokenBlaclistService blacklistService;

    public AuthController(TokenBlaclistService blacklistService){
        this.blacklistService = blacklistService;
    }


    @PostMapping("/login")
    public String login(@RequestParam String user_name, @RequestParam String password) {
        return authService.loginUser(user_name, password);
    }

    @PostMapping("/register")
    public String register(@RequestParam String user_name, @RequestParam  String email, @RequestParam String password){
         authService.registerUser(user_name, email, password);
         return "Register Successful";
    }

//    @PostMapping("/logout")
//    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
//        String jwt = token.substring(7);  // Bỏ tiền tố "Bearer "
//        blacklistService.addToBlacklist(jwt);
//
//        // Xóa SecurityContext nếu cần
//        SecurityContextHolder.clearContext();
//
//        return ResponseEntity.ok("Logged out successfully");
//    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            blacklistService.addToBlacklist(token);  // Thêm token vào blacklist
            return ResponseEntity.ok("Logged out successfully");
        } else {
            return ResponseEntity.badRequest().body("No token provided");
        }
    }

}
