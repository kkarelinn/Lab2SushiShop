package com.example.lab2sushishop.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Component
@EntityScan
public class Product implements Entity {

    private int ID;
    private int category_id;
    private Category category;
    private int linkprod_id;
    private Product linkProduct;

    @NotBlank()
    @Size(min = 2, max = 20)
    private String title;

    @Size(min = 3, max = 50)
    private String description;

    private String date;
    @Min(value = 0)
    private double priceUsd;

    public Product() {
    }

    public Product(int ID,
                   int category_id,
                   Category category,
                   int linkprod_id,
                   Product linkProduct,
                   String title,
                   String description,
                   String date,
                   double priceUsd) {
        this.ID = ID;
        this.category_id = category_id;
        this.category = category;
        this.linkprod_id = linkprod_id;
        this.linkProduct = linkProduct;
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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getLinkprod_id() {
        return linkprod_id;
    }

    public void setLinkprod_id(int linkprod_id) {
        this.linkprod_id = linkprod_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getLinkProduct() {

        return linkProduct;
    }

    public void setLinkProduct(Product linkProduct) {
        this.linkProduct = linkProduct;
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
                ", category_ID=" + ((category == null) ? "none" : category.getID()) +
                ", linkProd_ID=" + ((linkProduct == null) ? "none" : linkProduct.getID()) +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", priceUsd=" + priceUsd +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return ID == product.ID
                && category_id == product.category_id
                && linkprod_id == product.linkprod_id
                && Double.compare(product.priceUsd, priceUsd) == 0
                && category.equals(product.category)
                && Objects.equals(linkProduct, product.linkProduct)
                && title.equals(product.title)
                && Objects.equals(description, product.description)
                && date.equals(product.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, category_id, category, linkprod_id, linkProduct, title, description, date, priceUsd);
    }
}
