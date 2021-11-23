package com.ardt.sundry.service;

import com.ardt.sundry.dao.intf.UserDao;

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
}