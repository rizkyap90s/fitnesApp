package com.ky.fitnesApp.service;

import com.ky.fitnesApp.dto.BillingDto;
import com.ky.fitnesApp.dto.response.GetBillingResponse;

public interface PaymentService {

    GetBillingResponse getBilling(BillingDto billingDto);
}
