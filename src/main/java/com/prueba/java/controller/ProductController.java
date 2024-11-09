package com.prueba.java.controller;

import com.prueba.java.dto.DeleteProductDto;
import com.prueba.java.dto.ProductDto;
import com.prueba.java.model.Product;
import com.prueba.java.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/product", produces= MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody ProductDto productDto) {
        Product result = productService.addProduct(productDto.getFranchiseName(), productDto.getBranchName(),
                productDto.getName(), productDto.getStock());
        if(result == null){
            HashMap<String, String> map = new HashMap<>();
            map.put("error", "Franchise or branch doesn't exists, or the product already exists");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteProduct(@RequestBody DeleteProductDto deleteProductDto) {
        Product result = productService.deleteProduct(deleteProductDto.getFranchiseName(),
                deleteProductDto.getBranchName(),
                deleteProductDto.getName());
        if(result == null){
            HashMap<String, String> map = new HashMap<>();
            map.put("error", "Franchise, branch or product doesn't exists");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @PutMapping("/stock")
    public ResponseEntity<Object> updateStock(@RequestBody ProductDto productDto) {
        Product result = productService.newStock(productDto.getFranchiseName(),
                productDto.getBranchName(),
                productDto.getName(),
                productDto.getStock());
        if(result == null){
            HashMap<String, String> map = new HashMap<>();
            map.put("error", "Franchise, branch or product doesn't exists");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}
