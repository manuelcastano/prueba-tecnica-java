package com.prueba.java.dto;

public class DeleteProductDto {

    private String name;
    private String branchName;
    private String FranchiseName;

    public DeleteProductDto(String name, String branchName, String franchiseName) {
        this.name = name;
        this.branchName = branchName;
        this.FranchiseName = franchiseName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
