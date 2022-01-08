package com.example.lab2sushishop.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Component
@Scope("prototype")
public class Cart implements Entity {

    private int ID;

    private int user_ID;
    private int client_ID;

    private double totalPriceUAH;
    private String date;

    @NotBlank
    @Size(min=2, max=50)
    private String deliveryAddr;
    private String status;

    public Cart() { }

    public Cart(int user_ID,
                int client_ID,
                double totalPrice_uah,
                String date,
                String deliveryAddress,
                String status) {
        this.user_ID = user_ID;
        this.client_ID = client_ID;
        this.totalPriceUAH = totalPrice_uah;
        this.date = date;
        this.deliveryAddr = deliveryAddress;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public int getClient_ID() {
        return client_ID;
    }

    public void setClient_ID(int client_ID) {
        this.client_ID = client_ID;
    }

    public double getTotalPrice_uah() {
        return totalPriceUAH;
    }

    public void setTotalPrice_uah(double totalPriceUAH) {
        this.totalPriceUAH = totalPriceUAH;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeliveryAddress() {
        return deliveryAddr;
    }

    public void setDeliveryAddress(String deliveryAddr) {
        this.deliveryAddr = deliveryAddr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "ID=" + ID +
                ", user_ID=" + user_ID +
                ", client_ID=" + client_ID +
                ", totalPriceUAH=" + totalPriceUAH +
                ", date=" + date +
                ", deliveryAddr='" + deliveryAddr + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
