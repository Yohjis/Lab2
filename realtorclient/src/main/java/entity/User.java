package entity;

import java.util.UUID;

public class User {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {

        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;


    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{\nUUID: " + id.toString() + "\nFirst name: " + firstName + "\nLast name: " + lastName + "\n}";
    }

    public boolean equals(User user) {
        return user.getFirstName().equals(this.firstName) &&
                user.getLastName().equals(this.lastName) &&
                user.getEmail().equals(this.email) &&
                user.getId().equals(this.id);
    }
}