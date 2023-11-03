package com.ky.fitnesApp.controller;

import com.ky.fitnesApp.dto.request.SubscriptionRequest;
import com.ky.fitnesApp.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
    SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/startSubscription")
    public ResponseEntity<String> startSubscription(@RequestBody SubscriptionRequest subscriptionRequest) {
      subscriptionService.startSubscribe(subscriptionRequest);
        return ResponseEntity.ok("SUCCSES");
    }

}
