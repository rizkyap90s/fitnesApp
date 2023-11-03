package com.ky.fitnesApp.service;

import com.ky.fitnesApp.dto.TokenDto;
import com.ky.fitnesApp.dto.UserDto;
import com.ky.fitnesApp.dto.request.LoginRequest;

public interface AuthService {

    TokenDto login(LoginRequest loginRequest);

    TokenDto refrashToken(Long token);

    TokenDto generateToken(UserDto userDto);

    String removeToken(String Token);

}
