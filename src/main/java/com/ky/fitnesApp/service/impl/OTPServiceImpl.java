package com.ky.fitnesApp.service.impl;

import com.ky.fitnesApp.dto.UserDto;
import com.ky.fitnesApp.dto.request.VerifyRequest;
import com.ky.fitnesApp.repository.UserRepository;
import com.ky.fitnesApp.service.OTPService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OTPServiceImpl implements OTPService{
    private JavaMailSender javaMailSender;
    private UserRepository userRepository;
    private Map<String, String> otpStorage = new ConcurrentHashMap<>();
    public OTPServiceImpl(UserRepository userRepository, JavaMailSender javaMailSender, Map<String, String> otpStorage) {
        this.javaMailSender = javaMailSender;
        this.otpStorage = otpStorage;
        this.userRepository = userRepository;
    }

    @Override
    public String generateOTP() {
        int otp = (int) ((Math.random() * 900000) + 100000);
        return String.valueOf(otp);
    }

    @Override
    public void sendOTP(String to, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("OTP code");
        message.setText("Your OTP code is: " + otp);
        storeOTP(to, otp);

        javaMailSender.send(message);
    }

    @Override
    public void storeOTP(String email, String otp) {
        otpStorage.put(email, otp);
    }

    @Override
    public boolean verifyOTP(VerifyRequest verifyRequest) {
        String storedOTP = otpStorage.get(verifyRequest.getEmail());
        Optional<UserDto> userDto = userRepository.findById(verifyRequest.getUserId());
        UserDto updateStatusUser = userDto.get();
        if (storedOTP != null && storedOTP.equals(verifyRequest.getSubmittedOTP())) {

            updateStatusUser.setStatus("VALIDATED");
            userRepository.save(updateStatusUser);

            otpStorage.remove(verifyRequest.getEmail());
            return true;
        }

        return false;
    }
}