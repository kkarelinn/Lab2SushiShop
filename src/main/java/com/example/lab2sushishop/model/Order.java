package com.example.lab2sushishop.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;


@Component
public class Order implements Entity {
    private int ID;

    private int product_ID;


    private int cart_ID;

    private double totalOrdPriceUAH;

    @Min(value = 1)
    private int quantity;

    public Order() {
    }

    public Order(int product_ID, int cart_ID, double totalOrdPriceUAH, int quantity) {

        this.product_ID = product_ID;
        this.cart_ID = cart_ID;
        this.totalOrdPriceUAH = totalOrdPriceUAH;
        this.quantity = quantity;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int i) {
        this.ID = i;
    }

    public int getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public int getCart_ID() {
        return cart_ID;
    }

    public void setCart_ID(int cart_ID) {
        this.cart_ID = cart_ID;
    }

    public double getTotalOrdPriceUAH() {
        return totalOrdPriceUAH;
    }

    public void setTotalOrdPriceUAH(double totalOrdPriceUAH) {
        this.totalOrdPriceUAH = totalOrdPriceUAH;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", product_ID=" + product_ID +
                ", cart_ID=" + cart_ID +
                ", totalOrdPriceUAH=" + totalOrdPriceUAH +
                ", quantity=" + quantity +
                '}';
    }


    @Override
    public void setDate(String date) {

    }


}
