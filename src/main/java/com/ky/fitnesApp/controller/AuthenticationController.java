package com.ky.fitnesApp.controller;

import com.ky.fitnesApp.dto.TokenDto;
import com.ky.fitnesApp.dto.request.LoginRequest;
import com.ky.fitnesApp.service.AuthService;
import com.ky.fitnesApp.service.OTPService;
import com.ky.fitnesApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    UserService userService;
    OTPService otpService;
    AuthService authService;


    public AuthenticationController(AuthService authService, UserService userService, OTPService otpService) {
        this.userService = userService;
        this.otpService = otpService;
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequest loginRequest) {
        TokenDto tokenDto = authService.login(loginRequest);
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody Long idToken) {
        authService.removeToken(idToken);
        return ResponseEntity.ok("Logout Success");
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenDto> refresh(@RequestBody String token) {
        TokenDto newAuthToken = authService.refrashToken(token);
       return ResponseEntity.ok(newAuthToken);
    }

}
