package com.myRestaurant.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private int capacity;
    private List<Table> tableList;
    private List<MenuItem> menuItems;

    public Restaurant(int capacity, ArrayList<MenuItem> menuItems) {
        this.capacity = capacity;
        this.tableList = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            Table table = new Table(i + 1);
            this.tableList.add(table);
        }
        this.menuItems = menuItems;
    }

    public void printAllTables() {

        for (Table table : tableList) {
            System.out.println(table);
        }
    }

    public void printAvailableTables() {
        for (Table table : tableList) {
            if (table.isAvailable()) {
                System.out.println(table);
            }
        }
    }

    public void setUnavailable(int number) {
        for (Table table : tableList) {
            if (table.getTableNumber() == number) {
                table.setAvailable(false);
            }
        }
    }
    public void setAvailable(int number) {
        // this might need some verification that current table has been checked out before allowing to change.
        for (Table table : tableList) {
            if (table.getTableNumber() == number) {
                table.setAvailable(true);
            }
        }
    }

    public void printMenu(int menuNumber) {
        for (MenuItem menuItem : menuItems) {
            if(menuItem.getMenuNumber() == menuNumber) {
                System.out.println(menuItem);
            }
        }
    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "capacity=" + capacity +
                ", tableList=" + tableList +
                ", menuItems=" + menuItems +
                '}';
    }


}


