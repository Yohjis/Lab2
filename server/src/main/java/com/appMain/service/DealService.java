package com.appMain.service;

import com.appMain.Repository.ClientRepository;
import com.appMain.Repository.DealRepository;
import com.appMain.Repository.EstateRepository;
import com.appMain.entity.Client;
import com.appMain.entity.Deal;
import com.appMain.entity.Estate;
import com.appMain.entity.Realtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class DealService {
    private final EstateRepository estateRepository;
    private final DealRepository dealRepository;
    private final ClientRepository clientRepository;


    @Autowired
    public DealService(EstateRepository estateRepository, DealRepository dealRepository, ClientRepository clientRepository) {
        this.estateRepository = estateRepository;
        this.dealRepository = dealRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public List<Deal> getAllDeals() {
        return dealRepository.findAll();
    }

    public void addDeal(Realtor realtor, List<Estate> address, Client client) {
        List<Estate> toDeal = new ArrayList<>();
        for (Estate e : address) {
            if (client.getCash() < e.getPrice()) {
                System.out.println("Client(" + clientRepository.getFirstName() + " " + clientRepository.getLastName()
                        + ") price which can spend is " + clientRepository.getPrice() + ". \n Them can't reserve " + estateRepository.getEstate());
            } else {
                String estate = EstateRepository.findEstateByAddress(e.getAddress());
                if (estate == null) {
                    continue;
                }
                if (toDeal.size() > 0) {
                    Deal deal = new Deal((Estate) toDeal, client, realtor);
                    System.out.println("New deal has created: " + deal);
                    clientRepository.save(client);
                    dealRepository.save(deal);
                } else {
                    System.out.println("There is no " + e.getAddress() + ". It has been sold already.");
                    estateRepository.delete(estateRepository.getAddress());
                }
            }
        }

    }
}