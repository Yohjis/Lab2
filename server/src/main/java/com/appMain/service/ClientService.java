package com.appMain.service;

import com.appMain.Repository.ClientRepository;
import com.appMain.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository ;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public List<Client> getAllClients() {return clientRepository.findAll();}
}