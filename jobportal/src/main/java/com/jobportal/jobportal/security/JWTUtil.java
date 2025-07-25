package com.jobportal.jobportal.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

@Component
public class JWTUtil {
    private final String SECRET_KEY = "yXz9wG5vVqNs47L1KmfW9eBqTz6PjDcLmReTgYuHnBpQwErTzXcVuNaBzXdRgThY"; // 64-char

    private static final long EXPIRATION_TIME = 86400000; // 1 day

    public String generateToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
