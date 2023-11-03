package com.ky.fitnesApp.controller;

import com.ky.fitnesApp.dto.SubscriptionDto;
import com.ky.fitnesApp.dto.request.SubscriptionRequest;
import com.ky.fitnesApp.dto.response.GetBillingResponse;
import com.ky.fitnesApp.service.AuthService;
import com.ky.fitnesApp.service.OTPService;
import com.ky.fitnesApp.service.PaymentService;
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
    PaymentService paymentService;

    public PaymentController(PaymentService paymentService, AuthService authService, UserService userService, OTPService otpService) {
        this.userService = userService;
        this.otpService = otpService;
        this.authService = authService;
        this.paymentService = paymentService;
    }

    @PostMapping("/checkingBill")
    public ResponseEntity<GetBillingResponse> getBilling(@RequestBody SubscriptionRequest subscriptionDto) {
        GetBillingResponse billingResponse = paymentService.getBilling(subscriptionDto);
        return ResponseEntity.ok(billingResponse);
    }

    @PostMapping("/verifyBilling")
    public ResponseEntity<Boolean> verifyBilling(@RequestBody SubscriptionRequest subscriptionDto) {
        boolean billingResponse = paymentService.verifyBilling(subscriptionDto);
        return ResponseEntity.ok(billingResponse);
    }
}
