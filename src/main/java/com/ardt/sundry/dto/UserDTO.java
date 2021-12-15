package com.ardt.sundry.dto;

import javax.validation.constraints.NotNull;

import com.ardt.sundry.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class UserDTO {
    @NotNull public String id;
    private String email;
    private String name;

    public User toUser() {
        return User.builder()
            .id(id)
            .name(name)
            .email(email)
            .build();
    }
}