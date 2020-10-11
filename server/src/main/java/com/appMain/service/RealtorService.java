package com.appMain.service;

import com.appMain.Repository.RealtorRepository;
import com.appMain.entity.Realtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RealtorService {
    private final RealtorRepository realtorRepository;

    @Autowired
    public RealtorService(RealtorRepository realtorRepository) {
        this.realtorRepository = realtorRepository;
    }

    @Transactional(readOnly = true)
    public List<Realtor> getRealtorList() { return RealtorRepository.getRealtorList(); }
    public void addRealtor(Realtor realtor){ getRealtorList().add(realtor); }
    public void removeRealtor(Realtor realtor){
        if(getRealtorList().isEmpty());
        throw new RuntimeException("Not found");
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n#############################################");
        getRealtorList().stream().forEach(realtor -> stringBuilder.append(realtor.toString()));
        for(Realtor r: getRealtorList()){
            stringBuilder.append("\nid: ").append(r.getId()).append("\t firstName: ")
                    .append(r.getFirstName()).append("\n lastName: ").append(r.getLastName());
        }

        stringBuilder.append("\n\n#############################################");

        return stringBuilder.toString();
    }
}
