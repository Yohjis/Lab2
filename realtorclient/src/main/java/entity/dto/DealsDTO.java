package entity.dto;

import entity.Deal;

import java.util.List;

public class DealsDTO {
    private List<Deal> deal;

    public List<Deal> getDeals() {
        return deal;
    }

    public void setDeals(List<Deal> deals) {
        this.deal = deals;
    }
}