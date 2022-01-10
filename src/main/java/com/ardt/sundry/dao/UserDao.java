package com.ardt.sundry.dao;

import java.util.List;
import java.util.Optional;

import com.ardt.sundry.model.User;

public interface UserDao {

    // Create Review
    public void insertUser(User user);

    // Read User
    public List<User> findAll();

    // Read User
    public Optional<User> findById(String id);

    // Read User
    public Optional<User> findByEmail(String email);

    // Update User
    public String updateUser(User user);

    // Delete User
    public void deleteById(String id);
}
