package com.ardt.sundry.dao;

import java.util.List;

import com.ardt.sundry.model.MongoTest;

public interface MongoTestDao {

    // Create MongoTest
    public void insertMongo(String title);

    // Read MongoTest
    public List<MongoTest> findAll();

    // Read MongoTest
    public List<MongoTest> findAllByTitle(String title);

    // Delete MongoTest
    public void deleteByTitle(String title);

    // Delete MongoTest
    public void removeByTitle(String title);
}
