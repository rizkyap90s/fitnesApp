package com.ky.fitnesApp.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreditCardRequest {

    private Long userId;

    private String fullname;

    private String cardNumber;

    private String cvv;

    private LocalDateTime expiredDate;
}
