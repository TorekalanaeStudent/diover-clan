package com.go.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class BackendEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String employeeName;
    private String employeeEmail;
    private String employeePassword;
    private String employeePosition;
    private boolean currentlyInShift;

    @Column(name = "is_admin")
    @JsonProperty
    private boolean isAdmin;

    // Getters

    public String getEmployeeName(){
        return employeeName;
    }

    public String getEmployeeEmail(){
        return employeeEmail;
    }

    public String getEmployeePassword(){
        return employeePassword;
    }

    public String getEmployeePosition(){
        return employeePosition;
    }

    public Long getEmployeeId(){
        return employeeId;
    }

    public boolean getCurrentlyInShift(){
        return currentlyInShift;
    }

    public boolean getIsAdmin(){
        return isAdmin;
    }

    // Setters

    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }

    public void setEmployeeEmail(String employeeEmail){
        this.employeeEmail = employeeEmail;
    }

    public void setEmployeePassword(String employeePassword){
        this.employeePassword = employeePassword;
    }

    public void setEmployeePosition(String employeePosition){
        this.employeePosition = employeePosition;
    }

    public void setEmployeeId(Long employeeId){
        this.employeeId = employeeId;
    }

    public void setCurrentlyInShift(boolean currentlyInShift){
        this.currentlyInShift = currentlyInShift;
    }

    public void setIsAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }

}