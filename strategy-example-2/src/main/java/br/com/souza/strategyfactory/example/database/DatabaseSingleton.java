package br.com.souza.strategyfactory.example.database;

import br.com.souza.strategyfactory.example.model.UserEntity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DatabaseSingleton {

    private static DatabaseSingleton instance;
    private Map<UUID, UserEntity> DATABASE;

    private DatabaseSingleton(){
        DATABASE = new ConcurrentHashMap<>();
    }

    public static synchronized DatabaseSingleton getInstance(){
        if(!Objects.nonNull(instance)){
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    public void save(UserEntity user){
        DATABASE.put(user.getId(), user);
    }

    public UserEntity findById(UUID uuid){
        return DATABASE.get(uuid);
    }

    public Set<UUID> findAll(){
        return DATABASE.keySet();
    }
}
