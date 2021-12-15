package com.ardt.sundry.repository;

import com.ardt.sundry.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends MongoRepository<User, String> {
    public List<User> findById(UUID id);
    public void deleteById(UUID id);
    public Optional<User> findByEmail(String email);
}
