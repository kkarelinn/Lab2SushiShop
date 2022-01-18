package com.example.lab2sushishop.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;
import java.util.Objects;

@Component
@Scope("prototype")
public class Cart implements Entity {

    private int ID;
    private int user_ID;
    private int client_ID;
    private double totalPriceUAH;
    private String date;

    @NotBlank
    @Size(min = 2, max = 50)
    private String deliveryAddress;
    private String status;

    public Cart() {
    }

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
        this.deliveryAddress = deliveryAddress;
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
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
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
                ", deliveryAddr='" + deliveryAddress + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return ID == cart.ID
                && user_ID == cart.user_ID
                && client_ID == cart.client_ID
                && Double.compare(cart.totalPriceUAH, totalPriceUAH) == 0
                && date.equals(cart.date)
                && deliveryAddress.equals(cart.deliveryAddress)
                && status.equals(cart.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, user_ID, client_ID, totalPriceUAH, date, deliveryAddress, status);
    }
}
