package entity;

import java.util.UUID;

public class Estate {

    private UUID id;
    private String type;
    private Double price;
    private String address;
    private Realtor realtor;


    public Estate(){
        defineEstate();
    }

    public Estate(String address, String type, Double price, Realtor realtor){

        defineEstate();

        this.realtor = realtor;
        this.address = address;
        this.type = type;
        this.price = price;
    }


    public String getAddress() {
        return address;
    }

    public UUID getId(){
        return id;
    }
    public String getType(){
        return type;
    }
    public Double getPrice(){
        return price;
    }

    public Realtor getRealtor() {
        return realtor;
    }


    public void setRealtor(Realtor realtor) {
        this.realtor = realtor;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(Double price) {
        if(price > 0) {
            this.price = price;
        }else throw new RuntimeException("Price must be positive"); // catch in implementation
    }

    // Private

    private void defineEstate() {
        id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Estate {" +
                "id=" + id +
                ", adress='" + address + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                /*", estateWishList=" + estateWishList +*/
                '}';
    }
}



