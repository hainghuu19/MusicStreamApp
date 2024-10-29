package com.springboot.streammusic.config;

import com.springboot.streammusic.service.CustomUserDetailService;
import com.springboot.streammusic.service.TokenBlaclistService;
import com.springboot.streammusic.utility.JwtUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetails;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final TokenBlaclistService blaclistService;
    private final CustomUserDetailService userDetailService;

    public JwtFilter(JwtUtil jwtUtil, TokenBlaclistService blacklistService, CustomUserDetailService userDetailService) {
        this.jwtUtil = jwtUtil;
        this.blaclistService = blacklistService;
        this.userDetailService = userDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            if (jwtUtil.isTokenValid(token) && !blaclistService.isBlacklisted(token) ) {
                // Xác thực thành công, tiếp tục request
//                request.setAttribute("username", jwtUtil.extractUsername(token));

                String username = jwtUtil.extractUsername(token);

                UserDetails userDetails = userDetailService.loadUserByUsername(username);

                // Tạo đối tượng Authentication từ thông tin người dùng
                Authentication authentication = jwtUtil.getAuthentication(token, userDetails);

                // Cập nhật SecurityContext với đối tượng Authentication
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}
