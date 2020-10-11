package entity;



import java.util.*;

public class Client extends User {

    private List<Estate> estateWishList;
    private Calendar registrationDate;

    public Client(String firstName, String lastName, String email){

        super(firstName, lastName, email);
        defineClient();

    }


    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void addEstateToWishList(Estate estate) {
        estateWishList.add(estate);
    }

    public void deleteEstateFromWishList(UUID id){
        estateWishList.removeIf(e -> e.getId() == id);
    }

    public List<Estate> getEstateWishList(){
        return estateWishList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    // Private

    private void defineClient() {
        estateWishList = new ArrayList<Estate>();
        registrationDate = new GregorianCalendar();
    }
}
