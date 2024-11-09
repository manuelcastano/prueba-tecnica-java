package com.prueba.java.service;

import com.prueba.java.model.Franchise;
import com.prueba.java.repository.FranchiseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FranchiseService {

    @Autowired
    private FranchiseRepo franchiseRepo;

    public Franchise addFranchise(String name) {
        if(franchiseRepo.findByName(name) == null) {
            return franchiseRepo.save(new Franchise(name));
        }
        return null;
    }
}
