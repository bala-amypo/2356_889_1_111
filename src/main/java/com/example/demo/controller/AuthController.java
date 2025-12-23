package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest r) {
        return new AuthResponse(
                jwtUtil.generateToken(1L, r.getUsername(), r.getEmail(), r.getRole()),
                1L,
                r.getUsername(),
                r.getRole()
        );
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest r) {
        return register(r);
    }
}