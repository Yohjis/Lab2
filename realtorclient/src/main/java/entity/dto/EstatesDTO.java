package entity.dto;

import entity.Estate;

import java.util.List;

public class EstatesDTO {
    private List<Estate> estates;

    public List<Estate> getEstates() {
        return estates;
    }

    public void setEstates(List<Estate> estates) {
        this.estates = estates;
    }
}