package com.ardt.sundry.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data @Document(collection = "Review")
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id private String id;
    private String location;
    private String body;

    public Review(String location, String body){
        this.id = UUID.randomUUID().toString();
        this.location = location;
        this.body = body;
    }
}
