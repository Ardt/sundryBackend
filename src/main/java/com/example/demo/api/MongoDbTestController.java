package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Customer;
import com.example.demo.model.MongoTestDocument;
import com.example.demo.service.MongoDbTestService;
import com.mongodb.lang.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/mongo")
public class MongoDbTestController {

    private final MongoDbTestService mongoDbTestService;

    @Autowired
    public MongoDbTestController(MongoDbTestService mongoDbTestService) {
        this.mongoDbTestService = mongoDbTestService;
    }

    @GetMapping
    public List<Customer> findAll() {
        return mongoDbTestService.findAll();
    }

    @GetMapping(path = "/test")
    public String test() {
        return mongoDbTestService.getCollection("collectionNumber1");
    }

    @PostMapping
    public void addMongo(@Validated @NonNull @RequestBody String title) {
        mongoDbTestService.insertMongo(title);
    }

    @GetMapping(path = "{title}")
    public Optional<MongoTestDocument> findByTitle(String title) {
        return mongoDbTestService.findByTitle(title);
    }
    
    @GetMapping(path = "{title}/all")
    public List<MongoTestDocument> findAllByTitle(String title) {
        return mongoDbTestService.findAllByTitle(title);
    }
}