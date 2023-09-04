package dao;

import model.AppUser;
import model.Person;

import java.util.HashSet;
import java.util.List;

public interface PersonDAO {

    void persist(Person person);

    Person findById(int id);

    Person findByEmail(String email);

    void findAll(HashSet<Person> person);

    void remove();


}
