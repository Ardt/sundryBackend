package com.example.demo.api;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.MongoTestDocument;
import com.example.demo.service.MongoDbTestService;
import com.mongodb.lang.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping
    public void addMongo(@Validated @NonNull @RequestBody String title) {
        mongoDbTestService.insertMongo(title);
    }

    @GetMapping(path = "/")
    public List<MongoTestDocument> findAll() {
        return mongoDbTestService.findAll();
    }

    @GetMapping(path = "{title}")
    public Optional<MongoTestDocument> findByTitle(@PathVariable("title") String title) {
        return Optional.of(this.findAllByTitle(title).get(0));
    }

    @GetMapping(path = "{title}/all")
    public List<MongoTestDocument> findAllByTitle(@PathVariable("title") String title) {
        List<MongoTestDocument> returnValue = mongoDbTestService.findAllByTitle(title);
        return returnValue.isEmpty() ? Collections.emptyList() : returnValue;
    }

    @DeleteMapping(path = "{title}")
    public void deleteByTitle(@PathVariable("title") String title) {
        mongoDbTestService.deleteByTitle(title);
    }

    @DeleteMapping(path = "{title}/all")
    public void removeByTitle(@PathVariable("title") String title) {
        mongoDbTestService.removeByTitle(title);
    }
}