package com.prueba.java.repository;

import com.prueba.java.model.Branch;
import com.prueba.java.model.Franchise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepo extends CrudRepository<Branch, Long> {

    @Query("SELECT b FROM Branch b where b.name = :branchName and b.franchise.name = :franchiseName")
    public Branch findByName(@Param("branchName") String branchName, @Param("franchiseName") String franchiseName);

    @Query("SELECT b FROM Branch b where b.franchise.name = :franchiseName")
    public List<Branch> findByFranchise(@Param("franchiseName") String franchiseName);
}
