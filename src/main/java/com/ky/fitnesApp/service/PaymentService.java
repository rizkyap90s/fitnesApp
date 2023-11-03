package com.ky.fitnesApp.service;

import com.ky.fitnesApp.dto.request.SubscriptionRequest;
import com.ky.fitnesApp.dto.response.GetBillingResponse;

public interface PaymentService {
    GetBillingResponse getBilling(SubscriptionRequest subscriptionDto);
    boolean verifyBilling(SubscriptionRequest subscriptionDto);


}
