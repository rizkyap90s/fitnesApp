package com.ky.fitnesApp.service;

import com.ky.fitnesApp.dto.TokenDto;
import com.ky.fitnesApp.dto.UserDto;
import com.ky.fitnesApp.dto.request.LoginRequest;

public interface AuthService {

    TokenDto login(LoginRequest loginRequest);

    TokenDto refrashToken(String token);

    TokenDto generateToken(UserDto userDto);

    String removeToken(Long Token);

}
