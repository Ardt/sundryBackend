package com.ardt.sundry.dao.impl;

import java.util.List;
import java.util.Optional;

import com.ardt.sundry.dao.intf.UserDao;
import com.ardt.sundry.model.User;
import com.ardt.sundry.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository("UserMongo")
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private MongoTemplate mongoTemplate;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void insertUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
