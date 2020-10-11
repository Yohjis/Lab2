package com.appMain.Repository;

import com.appMain.entity.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EstateRepository extends JpaRepository<Estate, UUID>{


    Estate getAddress();
    Estate getEstate();

    @Query("SELECT e FROM Estate e WHERE e.address = :name")
    static String findEstateByAddress(@Param("address") String address) { return address; }

    @Query("SELECT e FROM Estate e INNER JOIN estateWishList e ON e.id = e.id WHERE e.id > 0")
    static List<Estate> getEstatesWishList() {
        return getEstatesWishList();
    }


}