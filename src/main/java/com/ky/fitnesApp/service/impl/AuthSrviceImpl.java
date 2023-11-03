package com.ky.fitnesApp.service.impl;

import com.ky.fitnesApp.dto.TokenDto;
import com.ky.fitnesApp.dto.UserDto;
import com.ky.fitnesApp.dto.request.LoginRequest;
import com.ky.fitnesApp.repository.TokenRepository;
import com.ky.fitnesApp.repository.UserRepository;
import com.ky.fitnesApp.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

@Service
public class AuthSrviceImpl implements AuthService {

    TokenRepository tokenRepository;

    PasswordEncoder passwordEncoder;

    UserRepository userRepository;

    public AuthSrviceImpl(UserRepository userRepository, TokenRepository tokenRepository, PasswordEncoder passwordEncoder) {
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public TokenDto login(LoginRequest loginRequest) {
        UserDto userDto = userRepository.findByEmail(loginRequest.getEmail());
        TokenDto tokenDto = new TokenDto();
        if (passwordEncoder.matches(loginRequest.getPassword(), userDto.getPassword())){
            tokenDto = generateToken(userDto);
            tokenRepository.save(tokenDto);
        }
        return tokenDto;
    }

    @Override
    public TokenDto refrashToken(String id) {
        TokenDto newToken = tokenRepository.findByToken(id);
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime expiredTime = LocalDateTime.now().plusDays(1);

        newToken.setToken(randomToken());
        newToken.setReleaseDate(currentTime);
        newToken.setExpiredDate(expiredTime);
        tokenRepository.save(newToken);
        return newToken;
    }

    @Override
    public TokenDto generateToken(UserDto userDto) {
        String token = randomToken();
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime expiredTime = LocalDateTime.now().plusDays(1);

        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);
        tokenDto.setUser(userDto);
        tokenDto.setExpiredDate(expiredTime);
        tokenDto.setReleaseDate(currentTime);

        tokenRepository.save(tokenDto);
        return tokenDto;
    }

    public static String randomToken() {
        byte[] randomBytes = new byte[10];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(randomBytes);
        String randomToken = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
        return randomToken;
    }

    @Override
    public String removeToken(Long token) {
        tokenRepository.deleteById(token);
        return "Deleted";
    }


}
