package com.project.back_end.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {

    // Generate a simple token (can be replaced with JWT later)
    public String generateToken(String username) {
        return username + "-" + UUID.randomUUID().toString();
    }

    // Validate token (basic validation)
    public boolean validateToken(String token) {
        return token != null && !token.isEmpty();
    }

    // Extract username from token
    public String extractUsername(String token) {
        if (token != null && token
