package com.ky.fitnesApp.repository;

import com.ky.fitnesApp.dto.MenuServiceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuServiceDto, Long> {
}
