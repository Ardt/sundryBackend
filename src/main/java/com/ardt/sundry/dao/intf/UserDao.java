package com.ardt.sundry.dao.intf;

import java.util.List;

import com.ardt.sundry.model.User;

public interface UserDao {

    // Create Review
    public void insertUser(String name, String email);

    // Read User
    public List<User> findAll();

    // Read User
    public List<User> findAllByEmail(String id);

    // Delete User
    public void deleteById(String id);
}
