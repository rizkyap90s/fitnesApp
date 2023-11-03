package com.ky.fitnesApp.repository;

import com.ky.fitnesApp.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long> {
    boolean existsByEmail(String email);

    UserDto findByEmail(String email);


}
