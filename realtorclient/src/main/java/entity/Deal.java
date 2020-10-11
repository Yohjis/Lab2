package entity;

import java.util.*;

public final class Deal {

    private UUID id;
    private List<Estate> estatesInDeal;
    private Double price;

    private Client client;
    private Calendar dealDate;
    private final Calendar c = Calendar.getInstance();

    public Deal(Estate estate, Client client) {

        // init definitions
        defineDeal();

        this.estatesInDeal.add(estate);
        this.client = client;
        this.price = estate.getPrice();
        this.dealDate = dealDate;

    }


    public void setEstatesInDeal(List<Estate> estatesInDeal) {
        this.estatesInDeal = estatesInDeal;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDealDate(Calendar dealDate) {
        this.dealDate = dealDate;
    }

    public double countPrice(ArrayList<Estate> estates){
        return estates.stream().mapToDouble(Estate::getPrice).sum();
    }

    public UUID getId() {
        return id;
    }

    public ArrayList<Estate> getEstateInDeal() {
        return getEstateInDeal();
    }

    public Double getPrice() {
        return price;
    }


    public Client getClient() {
        return client;
    }

    public Calendar getDealDate() {
        return dealDate;
    }

    // Private

    private void defineDeal() {
        this.id = UUID.randomUUID();
        estatesInDeal = new ArrayList<Estate>();
        dealDate = new GregorianCalendar();
        // dealDate.clear(); <- i am not sure you can use this, depends on functions
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + estatesInDeal +
                ", price=" + price +
                ", customer=" + client +
                ", orderDate=" + dealDate +
                ", c=" + c +
                '}';
    }
}
