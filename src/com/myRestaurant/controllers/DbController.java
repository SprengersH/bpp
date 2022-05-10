package com.myRestaurant.controllers;

import com.myRestaurant.database.DBMenuItems;
import com.myRestaurant.database.DBOrders;
import com.myRestaurant.entities.MenuItem;
import com.myRestaurant.entities.Order;

import java.sql.SQLException;
import java.util.ArrayList;

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
        insertProducts(order);

    }

    private void insertProducts(Order order) {
        for (MenuItem item : order.getOrderedMenuItems()) {
            String orderID = order.getOrderID();
            int productID = item.getMenuItemID();
            int tablenumber = order.getTableNumber();
            int active = order.getActive();
            dbo.insertOrderToProduct(orderID, productID, tablenumber, active);
            retrieveOrderID(1);
        }
    }

    public void retrieveOrderID(int tableNumber)  {
        String id = null;
        try {
            id = dbo.getOrderidFromTablenumber(tableNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(id);
    }
}
