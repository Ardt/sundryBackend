package com.ardt.sundry.dao;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import com.ardt.sundry.model.User;
import com.ardt.sundry.util.RandomModel;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@EnableMongoRepositories("com.ardt.sundry.dao")
@ComponentScan("com.ardt.sundry.dao")
class UserDaoTest {

    @Autowired(required = true)
    private UserDao user;

    private User initData;

    @BeforeEach
    public void setup() {
        initData = RandomModel.getRandomUser();
    }

    @DisplayName("basic CRUD test")
    @Test
    void basicCRUDTest() throws Exception {
        assertEquals(Optional.empty(), user.findById(initData.getId()));

        user.insertUser(initData);
        assertNotNull(user.findById(initData.getId()));
        assertNotNull(user.findByEmail(initData.getEmail()));
        assertEquals(1, user.findAll().size());
        assertEquals(user.findByEmail(initData.getEmail()), user.findById(initData.getId()));

        String changed = RandomStringUtils.random(10);
        initData.setName(changed);
        user.updateUser(initData);
        assertEquals(changed, user.findById(initData.getId()).get().getName());

        user.deleteById(initData.getId());
        assertEquals(Optional.empty(), user.findById(initData.getId()));
        assertEquals(0, user.findAll().size());
    }
}