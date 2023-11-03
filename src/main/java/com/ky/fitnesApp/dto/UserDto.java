package com.ky.fitnesApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String name;

    private String email;

    private String password;

    private String phone;

    private String status;

    @Column(name="credit_card")
    @Embedded
    private CreditCardDto creditCardDto;
}
