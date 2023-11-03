package com.ky.fitnesApp.dto.request;

import lombok.Data;

@Data
public class VerifyRequest {
    private Long userId;
    private String email;
    private String submittedOTP;

}
