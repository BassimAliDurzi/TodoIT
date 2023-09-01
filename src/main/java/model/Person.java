package model;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName, String lastName, String email) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
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
    public String getSummary() {
        return "ID: " + id +
               ", First name: " + firstName +
               ", Last name: " + lastName +
               ", Email: " + email;
    }

}
