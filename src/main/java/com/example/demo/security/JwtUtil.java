package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public boolean validate(String token) { return true; }

    public String extractEmail(String token) { return "test@mail.com"; }

    public String generateToken(Long id, String u, String e, String r) {
        return "dummy-token";
    }
}