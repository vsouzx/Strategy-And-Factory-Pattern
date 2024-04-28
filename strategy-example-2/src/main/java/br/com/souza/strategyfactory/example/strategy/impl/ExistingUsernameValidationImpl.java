package br.com.souza.strategyfactory.example.strategy.impl;

import br.com.souza.strategyfactory.example.database.DatabaseSingleton;
import br.com.souza.strategyfactory.example.dto.NewUserRequest;
import br.com.souza.strategyfactory.example.strategy.NewAccountValidationStrategy;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class ExistingUsernameValidationImpl implements NewAccountValidationStrategy {

    private final DatabaseSingleton database;

    public ExistingUsernameValidationImpl() {
        this.database = DatabaseSingleton.getInstance();
    }

    @SneakyThrows
    @Override
    public void execute(NewUserRequest request){
        System.out.println("Validando se username existe");
        if(!isValidUsername(request.getUsername())){
            throw new Exception("Ja existe um usuario registrado com esse username");
        }
    }

    private boolean isValidUsername(String username){
        return database.findAll().stream()
                .noneMatch(userUUID -> database.findById(userUUID).getUsername().equals(username));
    }
}
