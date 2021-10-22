package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

@Document(collection = "Spring_Test")
@AllArgsConstructor
@Data
@ToString
public class MongoTestDocument {

    private UUID id;
    private String title;

    public MongoTestDocument(String title) {
        Assert.hasText(title, "title must not be null or empty!");

        this.title = title;
    }
}
