package entity.dto;

import entity.Client;

import java.util.List;

public class ClientsDTO {
    private List<Client> client;

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> clients) {
        this.client = clients;
    }
}