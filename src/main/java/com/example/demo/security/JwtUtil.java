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
}