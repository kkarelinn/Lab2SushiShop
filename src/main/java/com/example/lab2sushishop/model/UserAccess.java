package com.example.lab2sushishop.model;

public enum UserAccess {
    ADMIN("admin"), MANAGER("manager"), EMPLOYEE("employee"), DEFAULT("customer");

   private String userRole;


  UserAccess(String userRole) {

        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }


}
