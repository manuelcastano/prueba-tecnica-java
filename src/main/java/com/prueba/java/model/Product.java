package com.prueba.java.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    public Product() {
    }

    public Product(String name, int stock, Branch branch) {
        this.name = name;
        this.stock = stock;
        this.branch = branch;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
