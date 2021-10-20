package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Mongo;
import com.example.demo.service.MongoDbTestService;
import com.mongodb.lang.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/v1/mongo")
@RestController
public class MongoDbTestController {

    private final MongoDbTestService mongoDbTestService;

    @Autowired
    public MongoDbTestController(MongoDbTestService mongoDbTestService) {
        this.mongoDbTestService = mongoDbTestService;
    }

    @GetMapping
    public String test() {
        return "test";
    }

    @PostMapping
    public void addMongo(@Validated @NonNull @RequestBody String title) {
        mongoDbTestService.insertMongo(title);
    }

    @GetMapping(path = "{title}")
    public Optional<Mongo> findByTitle(String title) {
        return mongoDbTestService.findByTitle(title);
    }
    
    @GetMapping(path = "{title}/all")
    public List<Mongo> findAllByTitle(String title) {
        return mongoDbTestService.findAllByTitle(title);
    }
}