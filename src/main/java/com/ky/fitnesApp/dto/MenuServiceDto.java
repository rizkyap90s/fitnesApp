package com.ky.fitnesApp.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
public class MenuServiceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String name;
    private BigInteger price;
    private String feature;
    private int durationInDay;
}
