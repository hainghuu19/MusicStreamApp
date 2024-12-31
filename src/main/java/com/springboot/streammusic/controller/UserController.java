//package com.springboot.streammusic.controller;
//
//
//import com.springboot.streammusic.model.DTO.UserProfileDTO;
//import com.springboot.streammusic.service.CustomUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//    @Autowired
//    private CustomUserDetailService userService;
//
//    @GetMapping("/profile")
//    public ResponseEntity<UserProfileDTO> getCurrentUserProfile(Authentication authentication) {
//        // Lấy username từ authentication object
//        String username = authentication.getName();
//        UserProfileDTO profile = userService.getUserProfile(username);
//        return ResponseEntity.ok(profile);
//    }
//
//}
