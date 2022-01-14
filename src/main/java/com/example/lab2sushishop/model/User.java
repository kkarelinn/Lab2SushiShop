package com.example.lab2sushishop.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Component
public class User implements Entity {

    private int ID;

    @NotBlank
    @Size(min = 2, max = 20)
    private String fullName;

    @Min(value = 1, message = "id should be more than 0")
    private int manager;
    User man;

    @NotBlank
    @Size(min = 2, max = 20)
    private String accessRole;

    public User() {
        super();
    }

    public User(int ID, String fullName, int manager, User man, String accessRole) {
        this.ID = ID;
        this.fullName = fullName;
        this.manager = manager;
        this.man = man;
        this.accessRole = accessRole;
    }

    public int getID() {
        return ID;
    }

    @Override
    public void setDate(String date) {
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getMan() {
        return man;
    }

    public void setMan(User man) {
        this.man = man;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public String getAccessRole() {
        return accessRole;
    }

    public void setAccessRole(String accessRole) {
        this.accessRole = accessRole;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_Id=" + ID +
                ", fullName='" + fullName + '\'' +
                ", manager=" + manager +
                ", accessRight='" + accessRole + '\'' +
                '}';
    }
}

