package com.example.demo.security;

import java.util.Base64;

public class JwtUtil {

    public String generateToken(String username, String role, String email, String userId) {
        String payload = username + ":" + role + ":" + email + ":" + userId;
        return Base64.getEncoder().encodeToString(payload.getBytes());
    }

    public void validate(String token) {
        try {
            Base64.getDecoder().decode(token);
        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }
}
