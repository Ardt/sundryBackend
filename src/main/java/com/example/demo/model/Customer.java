package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Document(collection = "customer")
@ToString
@AllArgsConstructor
public class Customer {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + "]";
    }
}