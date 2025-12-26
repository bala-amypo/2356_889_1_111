package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final Map<String, String> users = new HashMap<>();

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest req) {
        if (users.containsKey(req.getUsername())) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        users.put(req.getUsername(), req.getPassword());
        return ResponseEntity.ok("registered");
    }
}
