package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.MongoDbDao;
import com.example.demo.model.Customer;
import com.example.demo.model.MongoTestDocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MongoDbTestService {

    private final MongoDbDao mongoDbDao;

    @Autowired
    public MongoDbTestService(@Qualifier("MongoDB") MongoDbDao mongoDbDao)
    {
        this.mongoDbDao = mongoDbDao;
    }

    public void insertMongo(String title) {
        mongoDbDao.insertMongo(title);
    }

    public Optional<MongoTestDocument> findByTitle(String title) {
        return mongoDbDao.findByTitle(title);
    }
    
    public List<MongoTestDocument> findAllByTitle(String title) {
        return mongoDbDao.findAllByTitle(title);
    }

    public String getCollection(String title) {
        return mongoDbDao.getCollection(title);
    }

    public List<Customer> findAll() {
        return mongoDbDao.findAll();
    }
}