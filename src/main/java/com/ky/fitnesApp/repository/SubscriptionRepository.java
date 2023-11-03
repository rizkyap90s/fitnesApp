package com.ky.fitnesApp.repository;

import com.ky.fitnesApp.dto.SubscriptionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionDto, Long> {
    void deleteByUserId(Long id);
}
