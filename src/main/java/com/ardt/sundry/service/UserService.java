package com.ardt.sundry.service;

import java.util.List;
import java.util.Optional;

import com.ardt.sundry.dao.intf.UserDao;
import com.ardt.sundry.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("UserMongo") UserDao userDao) {
        this.userDao = userDao;
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public Optional<User> findById(String id) {
        return userDao.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public void deleteById(String id) {
        userDao.deleteById(id);
    }
}