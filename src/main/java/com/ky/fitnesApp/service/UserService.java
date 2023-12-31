package com.ky.fitnesApp.service;

import com.ky.fitnesApp.dto.CreditCardDto;
import com.ky.fitnesApp.dto.UserDto;
import com.ky.fitnesApp.dto.request.SignUpRequest;

import java.util.List;

public interface UserService {

    UserDto createUser(SignUpRequest userDto);
    SignUpRequest updateUser(SignUpRequest signUpRequest);
    UserDto updateCreditCard(CreditCardDto creditCardDto);
    List<UserDto> getUsers();
    String checkStatusUser(Long id);


}
