package br.com.souza.strategyfactory.example.strategy;

import br.com.souza.strategyfactory.example.dto.NewUserRequest;

public interface NewAccountValidationStrategy {

    void execute(NewUserRequest request);
}
