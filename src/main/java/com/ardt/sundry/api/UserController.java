package com.ardt.sundry.api;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.ardt.sundry.model.User;
import com.ardt.sundry.dto.UserDTO;
import com.ardt.sundry.service.UserService;
import com.mongodb.lang.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/")
    public List<User> findAll() {
        List<User> returnValue = userService.findAll();
        return returnValue.isEmpty() ? Collections.emptyList() : returnValue;
    }

    @GetMapping(path = "/id/{id}")
    public Optional<User> findById(@Validated @NotNull @PathVariable("id") String id) {
        return userService.findById(id);
    }

    @GetMapping(path = "/email/{email}")
    public Optional<User> findByEmail(@Validated @NotNull @PathVariable("email") String email) {
        return userService.findByEmail(email);
    }

    @PutMapping(path = "/")
    public void addLocation(@Validated @NonNull @RequestBody UserDTO userDTO) {
        userService.insertUser(userDTO.toUser());
    }

    @DeleteMapping(path = "/")
    public void deleteLocation(@Validated @NonNull @RequestBody String id) {
        userService.deleteById(id);
    }
}
