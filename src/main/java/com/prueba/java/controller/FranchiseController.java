package com.prueba.java.controller;

import com.prueba.java.dto.FranchiseDTO;
import com.prueba.java.model.Franchise;
import com.prueba.java.service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value="/franchise", produces= MediaType.APPLICATION_JSON_VALUE)
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    @PostMapping
    public ResponseEntity<Object> addFranchise(@RequestBody FranchiseDTO franchise) {
        Franchise result = franchiseService.addFranchise(franchise.getName());
        if(result == null){
            HashMap<String, String> map = new HashMap<>();
            map.put("error", "Franchise already exists");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}
