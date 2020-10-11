package com.appMain.entity.dto;

import com.appMain.entity.Deal;

import java.util.List;

public class DealsDTO {
    public Object setDeal;
    public List<Deal> deals;

    public DealsDTO() {
    }

    public DealsDTO(List<Deal> deals) {
        this.deals = deals;
    }

    public List<Deal> getAllDeals() {
        return deals;
    }

    public void setAllDeals(List<Deal> deals) {
        this.deals = deals;
    }
}