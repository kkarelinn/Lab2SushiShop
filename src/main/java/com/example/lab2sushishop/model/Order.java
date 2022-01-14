package com.example.lab2sushishop.model;

import org.springframework.stereotype.Component;
import javax.validation.constraints.Min;
import java.util.Objects;


@Component
public class Order implements Entity {

    private int ID;
    private int product_ID;
    Product product;
    private int cart_ID;
    private double total_price_uah;

    @Min(value = 1)
    private int quantity = 1;
    public Order() {
    }

    public Order(int ID, int product_ID, Product product, int cart_ID, double total_price_uah, int quantity) {
        this.ID = ID;
        this.product_ID = product_ID;
        this.product = product;
        this.cart_ID = cart_ID;
        this.total_price_uah = total_price_uah;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCart_ID() {
        return cart_ID;
    }

    public void setCart_ID(int cart_ID) {
        this.cart_ID = cart_ID;
    }

    public double getTotal_price_uah() {
        return total_price_uah;
    }

    public void setTotal_price_uah(double total_price_uah) {
        this.total_price_uah = total_price_uah;
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
                ", total_price_uah=" + total_price_uah +
                ", quantity=" + quantity +
                '}';
    }


    @Override
    public void setDate(String date) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return ID == order.ID
                && product_ID == order.product_ID
                && cart_ID == order.cart_ID
                && Double.compare(order.total_price_uah, total_price_uah) == 0
                && quantity == order.quantity
                && product.equals(order.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, product_ID, product, cart_ID, total_price_uah, quantity);
    }
}
