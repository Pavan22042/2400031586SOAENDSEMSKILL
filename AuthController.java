package com.example.tourist.controller;

import com.example.tourist.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtService jwtService;
    public AuthController(JwtService jwtService) { this.jwtService = jwtService; }

    @PostMapping("/token")
    public Map<String, String> createToken(@RequestBody Map<String, String> credentials) {
        // Demo credentials only. Replace with a database-backed user service for production.
        if (!"student".equals(credentials.get("username")) ||
                !"password123".equals(credentials.get("password"))) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }
        return Map.of("accessToken", jwtService.generateToken("student"), "tokenType", "Bearer");
    }
}
