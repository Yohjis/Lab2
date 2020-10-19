package com.appMain.Repository;

import com.appMain.entity.Client;
import com.appMain.entity.Deal;
import com.appMain.entity.Estate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public interface DealRepository extends  JpaRepository<Deal, UUID>{

}