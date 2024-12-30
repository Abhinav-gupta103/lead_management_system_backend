package com.lead_management_system.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lead_management_system.Service.AuthenticationService;
import com.lead_management_system.entities.AuthenticationResponse;
import com.lead_management_system.entities.User;

@RestController
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/api/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody User request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/api/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody User request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/api/refresh_token")
    public ResponseEntity refreshToken(
            HttpServletRequest request,
            HttpServletResponse response) {
        return authService.refreshToken(request, response);
    }
}