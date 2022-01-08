package com.example.lab2sushishop.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Component
public class Product implements Entity {

    private int ID;

    private int category_ID;

    private int linkProd_ID;

    @NotBlank()
    @Size(min=2, max=20)
    private String title;

    @Size(min=3, max=50)
    private String description;

    private String date;
    @Min(value = 0)
    private double priceUsd;

    public Product() {
       }

    public Product(String title,
                   String description,
                   String date,
                   double priceUsd,
                   int category_ID) {
        this.category_ID = category_ID;
        this.title = title;
        this.description = description;
        this.date = date;
        this.priceUsd = priceUsd;
    }

    public Product(int category_ID,
                   int linkProd_ID,
                   String title,
                   String description,
                   String date,
                   double priceUsd) {
        this.category_ID = category_ID;
        this.linkProd_ID = linkProd_ID;
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

    public int getCategory_ID() {
        return category_ID;
    }

    public void setCategory_ID(int category_ID) {
        this.category_ID = category_ID;
    }

    public int getLinkProd_ID() {
        return linkProd_ID;
    }

    public void setLinkProd_ID(int linkProd_ID) {
        this.linkProd_ID = linkProd_ID;
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
                ", category_ID=" + category_ID +
                ", linkProd_ID=" + linkProd_ID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", priceUsd=" + priceUsd +
                '}';
    }


}
