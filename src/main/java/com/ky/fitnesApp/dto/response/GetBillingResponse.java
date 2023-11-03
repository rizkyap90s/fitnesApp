package com.ky.fitnesApp.dto.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class GetBillingResponse {
    private String name;
    private BigInteger price;
}
