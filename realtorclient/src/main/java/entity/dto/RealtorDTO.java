package entity.dto;

import entity.Estate;
import entity.Realtor;

import java.util.List;

public class RealtorDTO {
    private List<Realtor> realtors;

    public List<Realtor> getRealtors() {
        return realtors;
    }

    public void setRealtors(List<Realtor> realtor) {
        this.realtors = realtors;
    }
}
