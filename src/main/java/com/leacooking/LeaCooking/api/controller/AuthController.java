package com.leacooking.LeaCooking.api.controller;

import com.leacooking.LeaCooking.api.config.security.JwtUtils;
import com.leacooking.LeaCooking.api.dto.authentification.AuthRequestDTO;
import com.leacooking.LeaCooking.api.dto.authentification.AuthResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO authRequestDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtUtils.generateToken(authRequestDTO.getUsername());
            AuthResponseDTO response = new AuthResponseDTO(
                    token,
                    authRequestDTO.getUsername(),
                    "Login successful"
            );

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthResponseDTO(null, null, "Invalid credentials"));
        }
    }
}
