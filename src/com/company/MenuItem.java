package com.company;

public class MenuItem {

    private int menuItemID;
    private String name;
    private String description;
    private double price;

    public MenuItem(int menuItemID, String name, String description, double price) {
        this.menuItemID = menuItemID;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void setPrice(double price) {
        // should this point to an update-query of price in the database?
        this.price = price;
    }

    public void addToOrder(int menuItemID) {

    }

    public void removeFromOrder(int menuItemID) {
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "menuItemID=" + menuItemID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
