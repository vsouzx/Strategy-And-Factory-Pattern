package br.com.souza.strategyfactory.example.strategy.impl;

import br.com.souza.strategyfactory.example.dto.NewUserRequest;
import br.com.souza.strategyfactory.example.strategy.NewAccountValidationStrategy;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class PasswordRequirementsValidationImpl implements NewAccountValidationStrategy {

    @SneakyThrows
    @Override
    public void execute(NewUserRequest request){
        System.out.println("Validando requerimentos da senha");
        if(!request.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).+$")){
            throw new Exception("A senha deve ter pelo menos: 1 caractere minusculo, 1 caractere maiusculo, 1 numero e 1 caractere especial");
        }
    }
}
