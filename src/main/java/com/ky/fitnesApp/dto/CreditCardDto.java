package com.ky.fitnesApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Embeddable
@Data
public class CreditCardDto {

    private String fullname;

    private String cardNumber;

    private String cvv;

    private LocalDateTime expiredDate;
}
