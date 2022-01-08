package com.example.lab2sushishop.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

public enum UserAccess {
    ADMIN, MANAGER, EMPLOYEE, CUSTOMER;


}
