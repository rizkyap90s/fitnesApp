package com.ky.fitnesApp.dto;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TokenDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String token;

    @Column(name="release_date")
    private LocalDateTime releaseDate;

    @Column(name="expired_date")
    private LocalDateTime expiredDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDto user;

}
