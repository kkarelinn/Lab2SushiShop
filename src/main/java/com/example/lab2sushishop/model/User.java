package com.example.lab2sushishop.model;

import org.springframework.stereotype.Component;

@Component
public class User implements Entity{
    private int ID;
    private String fullName;
    private int manager;
    private String accessRole;

    public User() {
       super();
    }

    public User(String fullName, int manager, UserAccess role) {
        this.fullName = fullName;
        this.manager = manager;
        this.accessRole = role.getUserRole();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

