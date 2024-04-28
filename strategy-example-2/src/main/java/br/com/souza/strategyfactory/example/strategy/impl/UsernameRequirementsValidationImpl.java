package br.com.souza.strategyfactory.example.strategy.impl;

import br.com.souza.strategyfactory.example.dto.NewUserRequest;
import br.com.souza.strategyfactory.example.strategy.NewAccountValidationStrategy;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class UsernameRequirementsValidationImpl implements NewAccountValidationStrategy {

    @SneakyThrows
    @Override
    public void execute(NewUserRequest request){
        System.out.println("Validando requerimentos do username");
        if(!request.getUsername().matches("^[a-zA-Z]+$")){
            throw new Exception("O nome deve conter apenas letras.");
        }
    }
}
