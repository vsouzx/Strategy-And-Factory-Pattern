package br.com.souza.strategyfactory.example.strategy.impl;

import br.com.souza.strategyfactory.example.database.DatabaseSingleton;
import br.com.souza.strategyfactory.example.dto.NewUserRequest;
import br.com.souza.strategyfactory.example.strategy.NewAccountValidationStrategy;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class ExistingEmailValidationImpl implements NewAccountValidationStrategy {

    private final DatabaseSingleton database;

    public ExistingEmailValidationImpl() {
        this.database = DatabaseSingleton.getInstance();
    }

    @SneakyThrows
    @Override
    public void execute(NewUserRequest request){
        System.out.println("Validando se e-mail existe");
        if(!isValidEmail(request.getEmail())){
            throw new Exception("Ja existe um usuario registrado com esse e-mail");
        }
    }

    private boolean isValidEmail(String email){
        return database.findAll().stream()
                .noneMatch(userUUID -> database.findById(userUUID).getEmail().equals(email));
    }
}
