package com.ky.fitnesApp.service.impl;

import com.ky.fitnesApp.dto.SubscriptionDto;
import com.ky.fitnesApp.dto.MenuServiceDto;
import com.ky.fitnesApp.dto.UserDto;
import com.ky.fitnesApp.dto.request.SubscriptionRequest;
import com.ky.fitnesApp.dto.response.GetBillingResponse;
import com.ky.fitnesApp.repository.MenuRepository;
import com.ky.fitnesApp.repository.UserRepository;
import com.ky.fitnesApp.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    MenuRepository menuRepository;
    UserRepository userRepository;

    public PaymentServiceImpl(MenuRepository menuRepository, UserRepository userRepository) {
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
    }

    @Override
    public GetBillingResponse getBilling(SubscriptionRequest subscriptionDto) {
        UserDto user = userRepository.getById(subscriptionDto.getUserId());
        MenuServiceDto menuServiceDto = menuRepository.getById(subscriptionDto.getServiceId());
        GetBillingResponse getBillingResponse = new GetBillingResponse();
        getBillingResponse.setName(user.getName());
        getBillingResponse.setPrice(menuServiceDto.getPrice());
        return getBillingResponse;
    }

    @Override
    public boolean verifyBilling(SubscriptionRequest subscriptionDto) {
        UserDto user = userRepository.getById(subscriptionDto.getUserId());
        MenuServiceDto service = menuRepository.getById(subscriptionDto.getServiceId());
        if (menuRepository.existsById(service.getId()) && userRepository.existsById(user.getId())){
            return true;
        }
        return false;
    }


}
