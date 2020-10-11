package com.appMain.controllers;

import com.appMain.entity.Client;
import com.appMain.entity.Estate;
import com.appMain.entity.Realtor;
import com.appMain.entity.dto.CreateDealDTO;
import com.appMain.entity.dto.DealsDTO;
import com.appMain.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("deals")
public class DealController{
    private final DealService dealService;

    @Autowired
    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostMapping
    public ResponseEntity<Void> createDeal(@RequestBody CreateDealDTO createDeal){
        Realtor realtor = createDeal.getRealtor();
        Client client = createDeal.getClient();
        List<Estate> estates = createDeal.getEstates();
        dealService.addDeal(realtor, estates, client);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public @ResponseBody DealsDTO getAllDeals(){
        DealsDTO dealsDTO = new DealsDTO();
        dealsDTO.setAllDeals(dealService.getAllDeals());
    return dealsDTO;
    }

}
