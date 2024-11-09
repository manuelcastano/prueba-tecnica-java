package com.prueba.java.dto;

public class BranchDto {

    private String branchName;
    private String franchiseName;

    public BranchDto(String branchName, String franchiseName) {
        this.branchName = branchName;
        this.franchiseName = franchiseName;
    }

    public BranchDto() {
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getFranchiseName() {
        return franchiseName;
    }

    public void setFranchiseName(String franchiseName) {
        this.franchiseName = franchiseName;
    }
}
