package com.prueba.java.repository;

import com.prueba.java.model.Franchise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepo extends CrudRepository<Franchise, Long> {

    @Query("SELECT f FROM Franchise f where f.name = :name")
    public Franchise findByName(@Param("name") String name);
}
