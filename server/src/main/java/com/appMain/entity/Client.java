package com.appMain.entity;

import javax.persistence.Entity;
import java.util.Calendar;
import java.util.GregorianCalendar;


@Entity
public class Client extends User {

    private Calendar registrationDate;
    private Double cash;

    public Client(String firstName, String lastName, String email, Double cash){
        super(firstName, lastName, email);
        defineClient();
    }

    public Client() {
        super();
    }

    public Double getCash(){return  cash;}
    public void setCash(Double cash) {this.cash = cash;}
    public Calendar getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(Calendar registrationDate) { this.registrationDate = registrationDate; }

    @Override
    public String toString() {
        return super.toString();
    }
    private void defineClient() {
        registrationDate = new GregorianCalendar();
    }

}
