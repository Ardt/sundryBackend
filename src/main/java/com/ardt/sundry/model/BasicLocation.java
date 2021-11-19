package com.ardt.sundry.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data @Document(collection = "BasicLocation")
@AllArgsConstructor
@NoArgsConstructor
public class BasicLocation {
    @Id private String id;
    private Double lat;
    private Double lng;
    private String name;

    public BasicLocation(Double lat, Double lng, String name) {
        this.id = UUID.randomUUID().toString();
        this.lat = lat;
        this.lng = lng;
        this.name = name;
    }

    public BasicLocation(Double lat, Double lng) {
        this.id = UUID.randomUUID().toString();
        this.lat = lat;
        this.lng = lng;
        this.name = "";
    }

    BasicLocation(String id, Double lat, Double lng) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.name = "";
    }
}
