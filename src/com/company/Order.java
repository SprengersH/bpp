package com.company;

import java.util.ArrayList;
import java.util.List;

public class Order {


    private int customerID;
    private List<MenuItem> menuItemList;
    private double orderPrice;

    public Order(int customerID) {
        this.customerID = customerID;

        this.menuItemList = new ArrayList<>();
        this.orderPrice = 0.00;
    }

    public Order(int orderID, int customerID, List<MenuItem> menuItemList, double orderPrice) {

        this.customerID = customerID;
        this.menuItemList = menuItemList;
        this.orderPrice = orderPrice;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void addToOrder(int orderID) {

    }

    public void printOrder() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Order{" +

                ", customerID=" + customerID +
                ", menuItemList=" + menuItemList +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
