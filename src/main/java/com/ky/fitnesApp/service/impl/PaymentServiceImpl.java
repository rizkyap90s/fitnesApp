package com.ky.fitnesApp.service.impl;

import com.ky.fitnesApp.dto.BillingDto;
import com.ky.fitnesApp.dto.ServiceDto;
import com.ky.fitnesApp.dto.UserDto;
import com.ky.fitnesApp.dto.response.GetBillingResponse;
import com.ky.fitnesApp.repository.ServiceRepository;
import com.ky.fitnesApp.repository.UserRepository;
import com.ky.fitnesApp.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    ServiceRepository serviceRepository;
    UserRepository userRepository;

    public PaymentServiceImpl(ServiceRepository serviceRepository, UserRepository userRepository) {
        this.serviceRepository = serviceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public GetBillingResponse getBilling(BillingDto billingDto) {
        UserDto user = userRepository.getById(billingDto.getUserId());
        ServiceDto serviceDto = serviceRepository.getById(billingDto.getServiceId());
        GetBillingResponse getBillingResponse = new GetBillingResponse();
        getBillingResponse.setName(user.getName());
        getBillingResponse.setPrice(serviceDto.getPrice());
        return getBillingResponse;
    }
}
