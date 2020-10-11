package entity.dto;

import entity.Client;
import entity.Estate;
import entity.Realtor;

import java.util.List;

public class CreateDealDTO {
    private Realtor realtor;
    private Client client;
    private List<Estate> estates;

    public Realtor getRealtor() {
        return realtor;
    }

    public void setRealtor(Realtor realtor) {
        this.realtor = realtor;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Estate> getEstates() {
        return estates;
    }

    public void setEstates(List<Estate> estates) {
        this.estates = estates;
    }
}