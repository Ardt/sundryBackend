package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.MongoTestDocument;

public interface MongoDbDao {

    // Create MongoTestDocument
    public void insertMongo(String title);

    // Read MongoTestDocument
    public List<MongoTestDocument> findAll();

    // Read MongoTestDocument
    public List<MongoTestDocument> findAllByTitle(String title);

    // Delete MongoTestDocument
    public void deleteByTitle(String title);

    // Delete MongoTestDocument
    public void removeByTitle(String title);
}
