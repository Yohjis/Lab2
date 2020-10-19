package com.appMain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "deals")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "deal_estate",
            joinColumns = @JoinColumn(name = "deal_id"),
            inverseJoinColumns = @JoinColumn(name = "estate_id"))
    private List<Estate> EstateInDeal;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "realtor_id")
    private Realtor realtor;
    private String address;
    private Double price;

    @Transient
    private LocalDateTime dealDate;

    public Deal() {

    }

    public Deal(Estate estate, Client client, Realtor realtor) {
        this.client = client;
        this.realtor = realtor;
        this.EstateInDeal = EstateInDeal;
        this.price = price;
        this.address= address;
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
    public LocalDateTime getDealDate() { return dealDate; }
    public LocalDateTime setDealDate (){ return dealDate; }
    public Client setClient(){return client;}
    public Realtor setRealtor(){return realtor;}
    public List<Deal> setDealId(List<Deal> dealId) {
        return dealId;
    }
    public Double getCountPrice(List<Estate> estates) { return estates.stream().mapToDouble(Estate::getPrice).sum(); }


    private void addDeal(Client client, Realtor realtor, LocalDateTime dealDate, Double price, String Address) {

        this.client= client;
        this.realtor= realtor;
        this.dealDate = dealDate;
        this.price = price;
        this.address = address;
    }

}
