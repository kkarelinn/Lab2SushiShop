package com.example.lab2sushishop.model;

public class Product implements Entity{

    private int ID;
    private int category_Id;
    private int linkProd_Id;
    private String title;
    private String description;
    private String date;
    private double priceUsd;

    public Product() {
       }

    public Product(String title,
                   String description,
                   String date,
                   double priceUsd) {

        this.title = title;
        this.description = description;
        this.date = date;
        this.priceUsd = priceUsd;
    }

    public Product(int category_Id,
                   int linkProd_Id,
                   String title,
                   String description,
                   String date,
                   double priceUsd) {
        this.category_Id = category_Id;
        this.linkProd_Id = linkProd_Id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.priceUsd = priceUsd;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(int category_Id) {
        this.category_Id = category_Id;
    }

    public int getLinkProd_Id() {
        return linkProd_Id;
    }

    public void setLinkProd_Id(int linkProd_Id) {
        this.linkProd_Id = linkProd_Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(double priceUsd) {
        this.priceUsd = priceUsd;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", category_Id=" + category_Id +
                ", linkProd_Id=" + linkProd_Id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", priceUsd=" + priceUsd +
                '}';
    }


}
