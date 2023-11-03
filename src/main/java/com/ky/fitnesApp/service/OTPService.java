package com.ky.fitnesApp.service;

import com.ky.fitnesApp.dto.request.VerifyRequest;

public interface OTPService {

    String generateOTP();
    void sendOTP(String to, String otp);
    boolean verifyOTP(VerifyRequest verifyRequest);
    void storeOTP(String email, String otp);

}
