package entity;

public class Realtor extends User{

    public Realtor(String firstName, String lastName, String email) {

        /*defineRealtor();*/
        super(firstName, lastName, email);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(User user) {
        return super.equals(user);
    }
}