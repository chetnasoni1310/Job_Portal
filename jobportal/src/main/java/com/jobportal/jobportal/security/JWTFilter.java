package com.jobportal.jobportal.security;

import java.io.IOException;
import java.util.Collections;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jobportal.jobportal.model.User;
import com.jobportal.jobportal.repository.UserRepository;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;
@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws ServletException, IOException {

    String header = request.getHeader("Authorization");

    System.out.println("🔍 Incoming request: " + request.getRequestURI());
    System.out.println("🔐 Authorization header: " + header);

    if (header != null && header.startsWith("Bearer ")) {
        String token = header.substring(7);
        try {
            String email = jwtUtil.extractUsername(token);
            System.out.println("✅ Extracted email: " + email);

            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                User user = userRepository.findByEmail(email).orElse(null);
                if (user != null && jwtUtil.validateToken(token)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            user.getEmail(), null,
                            Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
                    );
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    System.out.println("✅ Authenticated user: " + user.getEmail());
                }
            }
        } catch (Exception e) {
            System.out.println("❌ JWT Error: " + e.getMessage());
        }
    } else {
        System.out.println("⚠️ No Bearer token found, continuing unauthenticated");
    }

    chain.doFilter(request, response);
}
}
