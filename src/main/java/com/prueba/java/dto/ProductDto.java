package com.prueba.java.dto;

public class ProductDto {

    private String name;
    private int stock;
    private String branchName;
    private String FranchiseName;

    public ProductDto(String name, int stock, String branchName, String franchiseName) {
        this.name = name;
        this.stock = stock;
        this.branchName = branchName;
        this.FranchiseName = franchiseName;
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

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getFranchiseName() {
        return FranchiseName;
    }

    public void setFranchiseName(String franchiseName) {
        FranchiseName = franchiseName;
    }
}
