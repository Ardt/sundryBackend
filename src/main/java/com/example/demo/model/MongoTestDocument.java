package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

@Data @Document(collection = "Spring_Test")
@AllArgsConstructor
public class MongoTestDocument {
    private String title;
}
