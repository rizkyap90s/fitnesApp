package com.ky.fitnesApp.controller;

import com.ky.fitnesApp.dto.BillingDto;
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
@RequestMapping("/payment")
public class PaymentController {

    UserService userService;
    OTPService otpService;
    AuthService authService;

    public PaymentController(AuthService authService, UserService userService, OTPService otpService) {
        this.userService = userService;
        this.otpService = otpService;
        this.authService = authService;
    }

    @PostMapping("/checkingBill")
    public ResponseEntity<String> gettBilling(@RequestBody BillingDto billingDto) {

        return ResponseEntity.ok("Verify Failed");
    }
}
