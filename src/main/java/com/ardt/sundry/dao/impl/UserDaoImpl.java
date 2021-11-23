package com.ardt.sundry.dao.impl;

import java.util.List;

import com.ardt.sundry.dao.intf.UserDao;
import com.ardt.sundry.model.User;
import com.ardt.sundry.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("UserMongo")
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void insertUser(String name, String email) {
        // TODO Auto-generated method stub
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findAllByEmail(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        
    }
}
