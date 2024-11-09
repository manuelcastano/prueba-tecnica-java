package com.prueba.java.service;

import com.prueba.java.model.Branch;
import com.prueba.java.model.Franchise;
import com.prueba.java.model.Product;
import com.prueba.java.repository.BranchRepo;
import com.prueba.java.repository.FranchiseRepo;
import com.prueba.java.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private FranchiseRepo franchiseRepo;

    @Autowired
    private ProductRepo productRepo;

    public Product addProduct(String franchiseName, String branchName, String productName, int stock) {
        Franchise franchise = franchiseRepo.findByName(franchiseName);
        if(franchise != null) {
            Branch branch = branchRepo.findByName(branchName, franchise.getName());
            if(branch != null && productRepo.findByName(productName) == null) {
                return productRepo.save(new Product(productName, stock, branch));
            }
            return null;
        }
        return null;
    }

    public Product deleteProduct(String franchiseName, String branchName, String productName) {
        Franchise franchise = franchiseRepo.findByName(franchiseName);
        if(franchise != null) {
            Branch branch = branchRepo.findByName(branchName, franchise.getName());
            Product product = productRepo.findByName(productName);
            if(branch != null && product != null) {
                try{
                    productRepo.delete(product);
                } catch(Exception e){
                    return null;
                }
            }
            return product;
        }
        return null;
    }

    public Product newStock(String franchiseName, String branchName, String productName, int newStock) {
        Franchise franchise = franchiseRepo.findByName(franchiseName);
        if(franchise != null) {
            Branch branch = branchRepo.findByName(branchName, franchise.getName());
            Product product = productRepo.findByName(productName);
            Product result = null;
            if(branch != null && product != null) {
                int updates = productRepo.newStock(product.getId(), newStock);
                if(updates > 0){
                    result = productRepo.findByName(product.getName());
                }
            }
            return result;
        }
        return null;
    }
}
