package com.ky.fitnesApp.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubscriptionRequest {
    private Long userId;
    private Long serviceId;

}
