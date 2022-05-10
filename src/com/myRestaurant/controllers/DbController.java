package com.myRestaurant.controllers;

import com.myRestaurant.database.DBMenuItems;
import com.myRestaurant.database.DBOrders;
import com.myRestaurant.entities.MenuItem;
import com.myRestaurant.entities.Order;
import com.myRestaurant.view.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbController  {

    DBMenuItems dbm = new DBMenuItems();
    DBOrders dbo = new DBOrders();

    public DbController() {
    }

        public void showAllMenuItems() {
        System.out.println(dbm.selectAllMenuItems());
    }

    public void showMenu(int menuNumber) {
        System.out.println(dbm.selectMenu(menuNumber));
    }

    public ArrayList<MenuItem> loadMenuItems() {
        return dbm.selectAllMenuItems();
    }

    public void insertOrder(Order order) {
        dbo.insertOrder(order);
        dbo.insertOrderToProduct(order, order.getOrderedMenuItems());
        Main.run();
    }

    public String retrieveOrderID(int tableNumber)  {
        String id = null;
        try {
            id = dbo.getOrderidFromTablenumber(tableNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<MenuItem> retrieveItemList(String orderID) {
        return dbo.retrieveItemsFromOrder(orderID);
    }

    public void setAvailable(int tableNumber){
        dbo.setAvailable(tableNumber);
        System.out.println("Table " + tableNumber + " is set available");
    }
}
