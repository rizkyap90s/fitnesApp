package com.ky.fitnesApp.repository;

import com.ky.fitnesApp.dto.TokenDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<TokenDto, Long> {

    TokenDto findByToken(String token);

}
