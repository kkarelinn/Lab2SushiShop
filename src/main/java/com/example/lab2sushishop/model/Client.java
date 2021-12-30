package com.example.lab2sushishop.model;

public class Client implements Entity{
    private int ID;
    private String fullName;
    private String address;

    public Client() {
        super();
    }

    public Client(String fullName, String address) {
        this.fullName = fullName;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_Id=" + ID +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
