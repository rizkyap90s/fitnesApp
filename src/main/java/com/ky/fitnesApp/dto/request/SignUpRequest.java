package com.ky.fitnesApp.dto.request;

import lombok.Data;

@Data
public class SignUpRequest {
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String phone;
}
