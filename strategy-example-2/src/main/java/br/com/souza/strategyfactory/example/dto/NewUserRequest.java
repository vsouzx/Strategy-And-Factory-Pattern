package br.com.souza.strategyfactory.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewUserRequest {

    private String username;
    private String email;
    private String password;

}
