package com.ardt.sundry.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data @Document(collection = "Review")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    @Id private String id;
    private String userId;
    private String locationId;
    private String body;
}
