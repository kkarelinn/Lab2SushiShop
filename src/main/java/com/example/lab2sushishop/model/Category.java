package com.example.lab2sushishop.model;

public class Category implements Entity{
    private int ID;
    private String title;
    private String description;
    private String date;

    public Category() {
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
}
