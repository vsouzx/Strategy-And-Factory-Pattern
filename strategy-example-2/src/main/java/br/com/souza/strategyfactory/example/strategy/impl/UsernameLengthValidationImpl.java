package br.com.souza.strategyfactory.example.strategy.impl;

import br.com.souza.strategyfactory.example.dto.NewUserRequest;
import br.com.souza.strategyfactory.example.strategy.NewAccountValidationStrategy;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class UsernameLengthValidationImpl implements NewAccountValidationStrategy {

    @SneakyThrows
    @Override
    public void execute(NewUserRequest request){
        System.out.println("Validando tamanho do username");
        if(request.getUsername().length() <= 2){
            throw new Exception("Seu nome deve ter mais de 2 caracteres.");
        }
    }
}
