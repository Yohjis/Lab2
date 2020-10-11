package com.appMain.Repository;

import com.appMain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    String getFirstName();
    String getLastName();
    Double getPrice();
    List<Client> getEstateWishList();
    Client getClientByEmail();
}
