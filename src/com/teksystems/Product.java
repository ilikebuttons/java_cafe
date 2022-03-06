package com.teksystems;

public class Product {

    // attributes
    private String name;
    private double price;
    private String description;
    private int quantity;

    // constructors
    public Product() {}

    public Product (String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // methods
    public double calculateProductTotal()  {
        return price * quantity;
    }
}
