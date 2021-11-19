package com.ardt.sundry.dao_impl;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.UUID;

import com.ardt.sundry.dao.PersonDao;
import com.ardt.sundry.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> db = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        db.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> sellectAllPeople() {
        return db;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return db.stream()
            .filter(person -> person.getId().equals(id))
            .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }

        db.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id)
            .map(person -> {
                int indexOfPersonToDeleteUpdate = db.indexOf(person);
                if (indexOfPersonToDeleteUpdate >= 0) {
                    db.set(indexOfPersonToDeleteUpdate, new Person(id, update.getName()));
                    return 1;
                }
                return 0;
            })
            .orElse(0);
    }
}