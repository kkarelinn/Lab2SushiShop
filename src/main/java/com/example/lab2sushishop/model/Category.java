package com.example.lab2sushishop.model;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Component
@EntityScan

public class Category implements Entity {

    private int ID;
    @NotBlank
    @Size(min = 2, max = 20)
    private String title;
    @NotBlank
    @Size(min = 2, max = 50)
    private String description;
    private String date;

    public Category() {
    }

    public Category(int ID, String title, String description, String date) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Category(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    @Override
    public String toString() {
        return "Category{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return ID == category.ID
                && title.equals(category.title)
                && description.equals(category.description)
                && date.equals(category.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, title, description, date);
    }
}
