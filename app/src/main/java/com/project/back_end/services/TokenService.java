package com.project.back_end.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class TokenService {

    // Token validity: 1 hour
    private static final long EXPIRATION_TIME_MS = 60 * 60 * 1000;

    /**
     * Generates a JWT token using Jwts.builder()
     * Includes issuedAt and expiration timestamps
     */
    public String generateToken(String username, String role) {
        Date issuedAt = new Date();
        Date expiration = new Date(issuedAt.getTime() + EXPIRATION_TIME_MS);

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Returns the signing key used for JWT generation
     */
    private
