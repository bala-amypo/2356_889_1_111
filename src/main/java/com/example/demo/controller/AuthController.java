package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class AuthController {

    private final JwtUtil jwtUtil;
    private final Map<String, String> users = new HashMap<>();

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public ResponseEntity<?> register(AuthRequest req) {
        if (users.containsKey(req.getUsername())) {
            return ResponseEntity.badRequest().build();
        }
        users.put(req.getUsername(), req.getPassword());
        return ResponseEntity.ok("registered");
    }
}
