package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.MongoDbDao;
import com.example.demo.model.MongoTestDocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
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

    public List<MongoTestDocument> findAll() {
        return mongoDbDao.findAll();
    }

    public List<MongoTestDocument> findAllByTitle(String title) {
        return mongoDbDao.findAllByTitle(title);
    }
}