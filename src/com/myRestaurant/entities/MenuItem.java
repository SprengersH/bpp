package com.myRestaurant.entities;

public class MenuItem {

    private int menuItemID;
    private int menuNumber;
    private String courseType;
    private String name;
    private String description;
    private double price;

    public MenuItem(int menuItemID, int menuNumber, String courseType, String name, String description, double price) {
        this.menuItemID = menuItemID;
        this.menuNumber = menuNumber;
        this.courseType = courseType;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "menuItemID=" + menuItemID +
                ", menuNumber=" + menuNumber +
                ", courseType='" + courseType + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

}
