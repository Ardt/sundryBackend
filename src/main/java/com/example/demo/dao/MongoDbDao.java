package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Customer;
import com.example.demo.model.MongoTestDocument;

public interface MongoDbDao {

    public Optional<MongoTestDocument> findByTitle(String title);

    public List<MongoTestDocument> findAllByTitle(String lastName);

    public void insertMongo(String title);

    public String getCollection(String collectionName);

    public List<Customer> findAll();
}
