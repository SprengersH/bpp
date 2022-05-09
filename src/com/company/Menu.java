package com.company;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private int menuID;
    private List<MenuItem> menuItemList;

    public Menu(int menuID, ArrayList<MenuItem> menuItems) {
        this.menuID = menuID;
        this.menuItemList = menuItems;
    }
    public void addItemToMenu(int id, String name, String description, double price){
        // should this point to an insert in the database?
        MenuItem menuItem = new MenuItem(id, name, description, price);
        this.menuItemList.add(menuItem);
    }

    public void printThisMenu() {
        for (MenuItem i : menuItemList) {
            System.out.println(i);
        }
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuID=" + menuID +
                ", menuItemList=" + menuItemList +
                '}';
    }
}
