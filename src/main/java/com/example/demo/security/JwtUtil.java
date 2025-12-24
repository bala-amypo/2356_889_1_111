package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public boolean isTokenValid(String token) {
        return token != null && !token.isEmpty();
    }

    public String extractEmail(String token) {
        return "test@example.com";
    }

   
    public String generateToken(
            long id,
            String username,
            String email,
            String role
    ) {
        return "dummy-token";
    }
}