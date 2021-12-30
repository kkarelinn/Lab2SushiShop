package com.example.lab2sushishop.model;


public class Order {
    private int order_Id;
    private int product_Id;
    private int cart_Id;
    private double totalOrdPriceUAH;
    private int quantity;

    public Order() {
           }

    public Order(int order_Id, int product_Id, int cart_Id, double totalOrdPriceUAH, int quantity) {
        this.order_Id = order_Id;
        this.product_Id = product_Id;
        this.cart_Id = cart_Id;
        this.totalOrdPriceUAH = totalOrdPriceUAH;
        this.quantity = quantity;
    }

    public int getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(int order_Id) {
        this.order_Id = order_Id;
    }

    public int getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(int product_Id) {
        this.product_Id = product_Id;
    }

    public int getCart_Id() {
        return cart_Id;
    }

    public void setCart_Id(int cart_Id) {
        this.cart_Id = cart_Id;
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
                "order_Id=" + order_Id +
                ", product_Id=" + product_Id +
                ", cart_Id=" + cart_Id +
                ", totalOrdPriceUAH=" + totalOrdPriceUAH +
                ", quantity=" + quantity +
                '}';
    }
}
