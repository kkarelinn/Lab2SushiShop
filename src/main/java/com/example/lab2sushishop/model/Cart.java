package com.example.lab2sushishop.model;

import java.time.LocalDate;

public class Cart {
    private int cart_Id;
    private int user_Id;
    private int client_ID;
    private double totalPriceUAH;
    private LocalDate date;
    private String deliveryAddr;
    private String status;

    public Cart() { }

    public Cart(int cart_Id,
                int user_Id,
                int client_ID,
                double totalPriceUAH,
                LocalDate date,
                String deliveryAddr,
                String status) {
        this.cart_Id = cart_Id;
        this.user_Id = user_Id;
        this.client_ID = client_ID;
        this.totalPriceUAH = totalPriceUAH;
        this.date = date;
        this.deliveryAddr = deliveryAddr;
        this.status = status;
    }

    public int getCart_Id() {
        return cart_Id;
    }

    public void setCart_Id(int cart_Id) {
        this.cart_Id = cart_Id;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public int getClient_ID() {
        return client_ID;
    }

    public void setClient_ID(int client_ID) {
        this.client_ID = client_ID;
    }

    public double getTotalPriceUAH() {
        return totalPriceUAH;
    }

    public void setTotalPriceUAH(double totalPriceUAH) {
        this.totalPriceUAH = totalPriceUAH;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDeliveryAddr() {
        return deliveryAddr;
    }

    public void setDeliveryAddr(String deliveryAddr) {
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
                "cart_Id=" + cart_Id +
                ", user_Id=" + user_Id +
                ", client_ID=" + client_ID +
                ", totalPriceUAH=" + totalPriceUAH +
                ", date=" + date +
                ", deliveryAddr='" + deliveryAddr + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
