package model;

import dao.PersonDAO;
import sequencers.PersonalIdSequencer;

import java.util.HashSet;
import java.util.Objects;

import static sequencers.PersonalIdSequencer.*;

public class Person extends PersonalIdSequencer implements PersonDAO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    AppUser credentials;

    HashSet<Person> persons = new HashSet<>();

    public Person(String firstName, String lastName, String email) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = PersonalIdSequencer.nextId();
    }

    public int id() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("Not allowed to be null");
        this.firstName = firstName;
    }

    public String lastName() {
        return lastName;
    }

    public AppUser credentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("Not allowed to be null");
        this.lastName = lastName;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) throw new IllegalArgumentException("Not allowed to be null");
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID: " + nextId() +
                ", First Name: '" + firstName + '\'' +
                ", Last Name: '" + lastName + '\'' +
                ", Email: '" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public void persist(Person person) {
        persons.add(person);
    }

    @Override
    public Person findById(int id) {
        Person searchedPerson = new Person(id);
        for (Person person : persons) {
            if (person.id == searchedPerson.id) {
                System.out.println(person.toString());
            }
        }
        return searchedPerson;
    }

    @Override
    public Person findByEmail(String email) {
        Person searchedPerson = new Person(email);
        for (Person person : persons) {
            if (person.email.equals(searchedPerson.email)) {
                System.out.println(person.toString());
            }
        }
        return searchedPerson;
    }

    @Override
    public void findAll(HashSet<Person> person) {
        for (Person personObj: persons) {
            System.out.println(personObj);
        }

    }

    @Override
    public void remove() {
        persons.remove(findById(id));
    }
}
