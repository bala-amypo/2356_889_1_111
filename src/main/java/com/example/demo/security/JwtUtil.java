package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "secret-key-demo";
    private final long EXPIRY = 1000 * 60 * 60;

    public String generateToken(String username, String role, String email, String userId) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .claim("email", email)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRY))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public void validate(String token) {
        Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
    }
}
