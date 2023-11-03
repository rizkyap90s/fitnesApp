package com.ky.fitnesApp.controller;

import com.ky.fitnesApp.dto.CreditCardDto;
import com.ky.fitnesApp.dto.UserDto;
import com.ky.fitnesApp.dto.request.SignUpRequest;
import com.ky.fitnesApp.service.AuthService;
import com.ky.fitnesApp.service.OTPService;
import com.ky.fitnesApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class InfoManagemenController {

    UserService userService;
    OTPService otpService;
    AuthService authService;

    public InfoManagemenController(AuthService authService, UserService userService, OTPService otpService) {
        this.userService = userService;
        this.otpService = otpService;
        this.authService = authService;
    }

    @PostMapping("/update")
    public ResponseEntity<SignUpRequest> updateDataUser(@RequestBody SignUpRequest signUpRequest) {
        SignUpRequest newData = userService.updateUser(signUpRequest);
        return ResponseEntity.ok(newData);
    }

    @PostMapping("/updateCreditCard")
    public ResponseEntity<UserDto> updateCreaditCard(@RequestBody CreditCardDto creditCardDto) {
        UserDto newData = userService.updateCreditCard(creditCardDto);
        return ResponseEntity.ok(newData);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
       List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }





}
