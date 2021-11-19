package com.ardt.sundry.dao_impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ardt.sundry.dao.PersonDao;
import com.ardt.sundry.model.Person;

import org.springframework.stereotype.Repository;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> sellectAllPeople() {
        return List.of(new Person(UUID.randomUUID(), "From, POSTGRES DB"));
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
    
}