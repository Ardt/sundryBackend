package com.ardt.sundry.repository;

import com.ardt.sundry.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

class CustomUserRepositoryImpl implements CustomUserRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void updateUser(User user) {
        Update update = new Update();
        update.set("email", user.getEmail());
        update.set("name", user.getName());
        mongoTemplate.findAndModify(
            Query.query(Criteria.where("id").is(user.getId())),
            update, User.class);
    }
}
