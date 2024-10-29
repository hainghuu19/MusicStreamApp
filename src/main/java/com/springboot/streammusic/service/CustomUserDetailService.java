package com.springboot.streammusic.service;

import com.springboot.streammusic.model.User;
import com.springboot.streammusic.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Trả về đối tượng UserDetails từ entity User
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword_hash())
                .authorities("USER")  // Thêm các quyền (roles) nếu cần
                .build();
    }

}
