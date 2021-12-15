package com.ardt.sundry.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@Document(collection = "BasicLocation")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    @Id private String id;
    private Double lat;
    private Double lng;
    private String addrS;
    private String addrT;
    private String name;
}
