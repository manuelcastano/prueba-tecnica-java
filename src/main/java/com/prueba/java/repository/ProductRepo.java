package com.prueba.java.repository;

import com.prueba.java.model.Branch;
import com.prueba.java.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

    @Query("SELECT p FROM Product p where p.name = :name")
    public Product findByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.stock = :newStock where p.id = :id")
    public int newStock(@Param("id") Long id, @Param("newStock") int newStock);

    @Query("SELECT p FROM Product p where p.branch = :branch")
    public List<Product> findByBranch(@Param("branch") Branch branch);
}
