package com.ardt.sundry.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @Document(collection = "User")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id private String id;
    private String email;
    private String name;
}
