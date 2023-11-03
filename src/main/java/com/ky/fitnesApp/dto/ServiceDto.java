package com.ky.fitnesApp.dto;

import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
public class ServiceDto {
    private Long id;
    private String name;
    private BigInteger price;
    private String feature;
    private int durationInDay;
}
