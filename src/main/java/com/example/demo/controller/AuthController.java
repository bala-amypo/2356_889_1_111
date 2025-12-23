package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    public AuthController() {}

    private final JwtUtil jwtUtil = new JwtUtil();

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        String token = jwtUtil.generateToken(
                1L, req.getUsername(), req.getEmail(), req.getRole());
        return new AuthResponse(token, req.getRole());
    }
}