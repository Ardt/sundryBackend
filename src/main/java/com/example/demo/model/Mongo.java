package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Document("Spring_Test")
public class Mongo {

    @Id
    private Long id;
    private String title;

    @Override
    public String toString() {
        return "Mongo [id=" + id + ", title=" + title + "]";
    }
}