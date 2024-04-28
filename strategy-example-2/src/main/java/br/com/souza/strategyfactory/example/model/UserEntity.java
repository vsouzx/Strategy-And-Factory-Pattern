package br.com.souza.strategyfactory.example.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class UserEntity {

    private UUID id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime registrationTime;

}
