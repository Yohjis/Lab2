package com.appMain.Repository;

import com.appMain.entity.Realtor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RealtorRepository extends JpaRepository<Realtor, UUID> {
    static List<Realtor> getRealtorList() {return getRealtorList(); }

}
