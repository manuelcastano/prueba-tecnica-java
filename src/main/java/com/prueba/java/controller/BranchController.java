package com.prueba.java.controller;

import com.prueba.java.dto.BranchDto;
import com.prueba.java.dto.FranchiseDTO;
import com.prueba.java.model.Branch;
import com.prueba.java.model.Product;
import com.prueba.java.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/branch", produces= MediaType.APPLICATION_JSON_VALUE)
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping
    public ResponseEntity<Object> addBranch(@RequestBody BranchDto branch) {
        Branch result = branchService.addBranch(branch.getFranchiseName(), branch.getBranchName());
        if(result == null){
            HashMap<String, String> map = new HashMap<>();
            map.put("error", "Franchise doesn't exists or branch already exists");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @GetMapping("/maxStock")
    public ResponseEntity<Object> getMaxProduct(@RequestBody FranchiseDTO franchiseDto) {
        HashMap<String, String> result = branchService.maxStock(franchiseDto.getName());
        if(result == null){
            HashMap<String, String> map = new HashMap<>();
            map.put("error", "Franchise doesn't exists or branch already exists");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}
