package com.appMain.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "deals")
    public class Deal {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "deal_estate",
            joinColumns = @JoinColumn(name = "deal_id"),
            inverseJoinColumns = @JoinColumn(name = "estate_id"))

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "deal_id")


    private Double price;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "estate_id")
    private Client client;
    private Realtor realtor;
    private String address;

    @Transient
    private LocalDateTime dealDate;



    public Deal(Estate estate, Client client, Realtor realtor) {
        defineDeal();
        this.client = client;
        this.realtor = realtor;
        this.price = estate.getPrice();
        this.address= estate.getAddress();
    }

    public Deal() {

    }

    private void defineDeal() {
        this.id = UUID.randomUUID();
    }

    public UUID getDealId() {
        return id;
    }

    public ArrayList<Estate> getEstateInDeal() {
        return getEstateInDeal();
    }
    public Realtor getRealtor(){return realtor;}
    public Client getClient() { return client; }
    public Double getPrice() { return price; }
    public LocalDateTime getDealDate() { return dealDate; }
    public String getAddress(){return address;}
    public Double setPrice(){return price;}
    public LocalDateTime setDealDate (){ return dealDate; }
    public Client setClient(){return client;}
    public Realtor setRealtor(){return realtor;}
    public List<Deal> setDealId(List<Deal> dealId) {
        return dealId;
    }
    public String setAddress(){return address;}
    public Double getCountPrice(List<Estate> estates) { return estates.stream().mapToDouble(Estate::getPrice).sum(); }


    private void addDeal(Client client, Realtor realtor, LocalDateTime dealDate, Double price, String Address) {

        this.client= client;
        this.realtor= realtor;
        this.dealDate = dealDate;
        this.price = price;
        this.address = address;
    }
}
