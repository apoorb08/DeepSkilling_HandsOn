package com.cognizant.springlearn.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

    @PostMapping("/authenticate")
    public Map<String, String> authenticate(Authentication authentication) {
        String user = authentication.getName();
        String token = generateToken(user);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return tokenMap;
    }

    private String generateToken(String user) {
        String secret = "my-secret-key-that-is-long-enough";
        return Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
