package com.prueba.java.service;

import com.prueba.java.model.Branch;
import com.prueba.java.model.Franchise;
import com.prueba.java.model.Product;
import com.prueba.java.repository.BranchRepo;
import com.prueba.java.repository.FranchiseRepo;
import com.prueba.java.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BranchService {

    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private FranchiseRepo franchiseRepo;

    @Autowired
    private ProductRepo productRepo;


    public Branch addBranch(String FranchiseName, String branchName) {
        Franchise franchise = franchiseRepo.findByName(FranchiseName);
        if(franchise != null && branchRepo.findByName(branchName, franchise.getName()) == null) {
            return branchRepo.save(new Branch(branchName, franchise));
        }
        return null;
    }

    public HashMap<String, String> maxStock(String FranchiseName){
        HashMap<String, String> map = new HashMap<>();
        Franchise franchise = franchiseRepo.findByName(FranchiseName);
        if(franchise != null) {
            List<Branch> branchs = branchRepo.findByFranchise(franchise.getName());
            branchs.forEach(b -> {
                        List<Product> products = productRepo.findByBranch(branchRepo.findByName(b.getName(), franchise.getName()));
                        Product maxStock = products.stream().max(Comparator.comparing(Product::getStock)).orElseThrow(NoSuchElementException::new);
                        map.put(b.getName(), maxStock.getName());
                    }
            );
            return map;
        }
        return map;
    }
}
