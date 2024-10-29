package com.springboot.streammusic.service;

import com.springboot.streammusic.model.User;
import com.springboot.streammusic.repository.UserRepository;
import com.springboot.streammusic.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String loginUser(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));

        if (user == null || !passwordEncoder.matches(password, user.getPassword_hash())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtUtil.generateToken(username);
    }

    public User registerUser(String username, String email, String password){
        if (userRepository.existsByUsername(username) || userRepository.existsByEmail(email) ){
            throw new RuntimeException("Username or email has already existed");
        }

        String hashPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword_hash(hashPassword);
        return userRepository.save(user);
    }


}
