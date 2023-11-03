package com.ky.fitnesApp.service.impl;

import com.ky.fitnesApp.dto.SubscriptionDto;
import com.ky.fitnesApp.dto.request.SubscriptionRequest;
import com.ky.fitnesApp.repository.SubscriptionRepository;
import com.ky.fitnesApp.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    SubscriptionRepository repository;

    public SubscriptionServiceImpl(SubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public String startSubscribe(SubscriptionRequest subscriptionRequest) {
        SubscriptionDto subscriptionDto = new SubscriptionDto();
        subscriptionDto.setServiceId(subscriptionRequest.getServiceId());
        subscriptionDto.setUserId(subscriptionRequest.getUserId());
        subscriptionDto.setStartTime(LocalDateTime.now());
        subscriptionDto.setEndTime(LocalDateTime.now().plusMonths(1));
        repository.save(subscriptionDto);
        return "Subscribe Success";
    }

}
