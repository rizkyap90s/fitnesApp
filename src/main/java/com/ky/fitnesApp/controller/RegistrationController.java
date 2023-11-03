package com.ky.fitnesApp.controller;

import com.ky.fitnesApp.dto.UserDto;
import com.ky.fitnesApp.dto.request.SignUpRequest;
import com.ky.fitnesApp.dto.request.VerifyRequest;
import com.ky.fitnesApp.service.AuthService;
import com.ky.fitnesApp.service.OTPService;
import com.ky.fitnesApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    UserService userService;
    OTPService otpService;
    AuthService authService;

    public RegistrationController(AuthService authService, UserService userService, OTPService otpService) {
        this.userService = userService;
        this.otpService = otpService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpRequest signUpRequest) {
        String newOTP = otpService.generateOTP();
        UserDto userDto = userService.createUser(signUpRequest);
        otpService.sendOTP(signUpRequest.getEmail(), newOTP);

        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyOTP(@RequestBody VerifyRequest verifyRequest) {
        if (otpService.verifyOTP(verifyRequest)){
            return ResponseEntity.ok("Verify Success");
        }
        return ResponseEntity.ok("Verify Failed");
    }

    @PostMapping("/checkStatus")
    public ResponseEntity<String> checkStatusUser(@RequestBody Long userId) {
        String status = userService.checkStatusUser(userId);
        return ResponseEntity.ok(status);
    }

}
