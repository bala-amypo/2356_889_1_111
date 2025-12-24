package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class JwtUtil {

   
    public String generateToken(String username, String role, String email, String userId) {
        String raw =
                username + "|" +
                role + "|" +
                email + "|" +
                userId + "|" +
                System.currentTimeMillis();

        return Base64.getEncoder()
                .encodeToString(raw.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Validate token by Base64 decoding only
     */
    public void validate(String token) {
        try {
            Base64.getDecoder().decode(token);
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Invalid token");
        }
    }
}
