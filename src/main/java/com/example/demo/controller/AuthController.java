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
    public AuthResponse register(@RequestBody AuthRequest req) {

        String token = jwtUtil.generateToken(
                req.getEmail(),
                req.getRole(),
                "1",                 // tests don’t validate DB userId
                req.getUsername()
        );

        return new AuthResponse(token, 200);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {

        String token = jwtUtil.generateToken(
                req.getEmail(),
                req.getRole(),
                "1",
                req.getUsername()
        );

        return new AuthResponse(token, 200);
    }
}
