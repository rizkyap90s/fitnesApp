package com.ky.fitnesApp.repository;

import com.ky.fitnesApp.dto.ServiceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceDto, Long> {
}
