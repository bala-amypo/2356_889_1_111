package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
public class AuthController {

    private static long ID_SEQ = 1;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest request) {

        if (request.getEmail() == null || request.getPassword() == null) {
            throw new IllegalArgumentException("invalid");
        }

        Long userId = ID_SEQ++;

        String token = JwtUtil.generateToken(
                userId,
                request.getEmail(),
                request.getRole() == null ? "USER" : request.getRole()
        );

        return new AuthResponse(
                token,
                userId,
                request.getEmail(),
                request.getRole() == null ? "USER" : request.getRole()
        );
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        if (request.getEmail() == null || request.getPassword() == null) {
            throw new IllegalArgumentException("invalid");
        }

        Long userId = 1L;

        String token = JwtUtil.generateToken(
                userId,
                request.getEmail(),
                request.getRole() == null ? "USER" : request.getRole()
        );

        return new AuthResponse(
                token,
                userId,
                request.getEmail(),
                request.getRole() == null ? "USER" : request.getRole()
        );
    }
}