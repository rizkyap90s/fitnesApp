package com.ky.fitnesApp.service.impl;

import com.ky.fitnesApp.dto.CreditCardDto;
import com.ky.fitnesApp.dto.UserDto;
import com.ky.fitnesApp.dto.request.SignUpRequest;
import com.ky.fitnesApp.repository.UserRepository;
import com.ky.fitnesApp.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    PasswordEncoder passwordEncoder;


    public UserServiceImpl(PasswordEncoder passwordEncoder,UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder= passwordEncoder;
    }

    @Override
    public UserDto createUser(SignUpRequest signUpRequest) {
        String email = signUpRequest.getEmail();
        String password = passwordEncoder.encode(signUpRequest.getPassword());

        if(userRepository.existsByEmail(email)){
            throw new EntityNotFoundException(email + " ALREADY USED");
        }

        UserDto userDto = new UserDto();
        userDto.setName(signUpRequest.getName());
        userDto.setEmail(signUpRequest.getEmail());
        userDto.setPhone(signUpRequest.getPhone());
        userDto.setPassword(password);
        userDto.setStatus("NOT VALIDATED");

        userRepository.save(userDto);

        return userDto;
    }

    @Override
    public SignUpRequest updateUser(SignUpRequest signUpRequest) {
        Long id = signUpRequest.getUserId();
        if(!userRepository.existsById(id)){
            throw new EntityNotFoundException(id + " NOT FOUND");
        }
        String password = passwordEncoder.encode(signUpRequest.getPassword());

        Optional<UserDto> getUSer = userRepository.findById(id);
        UserDto userDto = getUSer.get();
        userDto.setName(signUpRequest.getName());
        userDto.setEmail(signUpRequest.getEmail());
        userDto.setPassword(password);
        userDto.setPhone(signUpRequest.getPhone());

        userRepository.save(userDto);
        return signUpRequest;
    }

    @Override
    public UserDto updateCreditCard(CreditCardDto creditCardDto) {
        Long id = creditCardDto.getUserId();
        if(!userRepository.existsById(id)){
            throw new EntityNotFoundException(id + " NOT FOUND");
        }
        Optional<UserDto> getUSer = userRepository.findById(id);
        UserDto userDto = getUSer.get();
        userDto.setCreditCard(creditCardDto);

        userRepository.save(userDto);
        return userDto;
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public String checkStatusUser(Long id) {
        Optional<UserDto> userDto = userRepository.findById(id);
        if(!userDto.isPresent()){
            return "NOT REGISTERED";
        }
        return userDto.get().getStatus();
    }

}
