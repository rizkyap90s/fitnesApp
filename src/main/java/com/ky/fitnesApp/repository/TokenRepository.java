package com.ky.fitnesApp.repository;

import com.ky.fitnesApp.dto.TokenDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<TokenDto, Long> {
    TokenDto deleteByToken(String token);

}
