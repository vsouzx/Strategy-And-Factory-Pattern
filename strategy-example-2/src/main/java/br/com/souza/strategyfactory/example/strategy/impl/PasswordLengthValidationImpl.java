package br.com.souza.strategyfactory.example.strategy.impl;

import br.com.souza.strategyfactory.example.dto.NewUserRequest;
import br.com.souza.strategyfactory.example.strategy.NewAccountValidationStrategy;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class PasswordLengthValidationImpl implements NewAccountValidationStrategy {

    @SneakyThrows
    @Override
    public void execute(NewUserRequest request){
        System.out.println("Validando tamanho da senha");
        if(request.getPassword().length() < 8 || request.getPassword().length() > 12) {
            throw new Exception("A senha deve ter no mínimo 8 caracteres e no máximo 12 caracteres.");
        }
    }
}
