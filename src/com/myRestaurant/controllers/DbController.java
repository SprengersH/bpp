package com.myRestaurant.controllers;

import com.myRestaurant.database.DBMenuItems;
import com.myRestaurant.entities.MenuItem;

import java.util.ArrayList;

public class DbController {

    DBMenuItems dbm = new DBMenuItems();

    public void showAllMenuItems() {
        System.out.println(dbm.selectAllMenuItems());
    }

    public void showMenu(int menuNumber) {
        System.out.println(dbm.selectMenu(menuNumber));
    }

    public ArrayList<MenuItem> loadMenuItems() {
        return dbm.selectAllMenuItems();
    }
}
