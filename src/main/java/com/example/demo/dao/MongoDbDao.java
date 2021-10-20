package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Mongo;

public interface MongoDbDao {

    public Optional<Mongo> findByTitle(String title);

    public List<Mongo> findAllByTitle(String lastName);

    public void insertMongo(UUID id, String title);
    
    default void insertMongo(String title) {
        UUID id = UUID.randomUUID();
        insertMongo(id, title);
    }
}
