package com.ky.fitnesApp.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class SubscriptionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private Long userId;
    private Long serviceId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
