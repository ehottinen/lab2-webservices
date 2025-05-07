package com.example.authservice.controller;

import com.example.authservice.model.LoginRequest;
import com.example.authservice.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            System.out.println("Username: " + request.getUsername());
            System.out.println("Password: " + request.getPassword());

            if ("user".equals(request.getUsername()) && "password".equals(request.getPassword())) {
                String token = JwtUtil.generateToken(request.getUsername());
                return ResponseEntity.ok(Map.of("token", token));
            }

            return ResponseEntity.status(401).body("Invalid credentials");

        } catch (Exception e) {
            e.printStackTrace();  // error log
            return ResponseEntity.status(500).body("Server error: " + e.getMessage());
        }
    }
}
