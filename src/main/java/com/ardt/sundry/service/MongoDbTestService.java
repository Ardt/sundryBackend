package com.ardt.sundry.service;

import java.util.List;

import com.ardt.sundry.dao.MongoTestDao;
import com.ardt.sundry.model.MongoTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MongoDbTestService {

    private final MongoTestDao mongoDbDao;

    @Autowired
    public MongoDbTestService(@Qualifier("MongoDB") MongoTestDao mongoDbDao)
    {
        this.mongoDbDao = mongoDbDao;
    }

    public void insertMongo(String title) {
        mongoDbDao.insertMongo(title);
    }

    public List<MongoTest> findAll() {
        return mongoDbDao.findAll();
    }

    public List<MongoTest> findAllByTitle(String title) {
        return mongoDbDao.findAllByTitle(title);
    }

    public void deleteByTitle(String title) {
        mongoDbDao.deleteByTitle(title);
    }

    public void removeByTitle(String title) {
        mongoDbDao.removeByTitle(title);
    }
}