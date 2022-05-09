package com.company;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private int billID;
    private int customerID;
    private double totalAmount;
    private boolean activeStatus;
    private List<Order> orders;


    public Bill(int billID, int customerID, double totalAmount, boolean status, List<Order> orderList) {
        this.billID = billID;
        this.customerID = customerID;
        this.totalAmount = totalAmount;
        this.activeStatus = status;
        this.orders = new ArrayList<>();
    }

    public Bill(int customerID) {
        this.customerID = customerID;
        this.totalAmount = 0;
        this.activeStatus = true;
        this.orders = new ArrayList<>();

    }
    public void addOrderToBill(Order order) {
        orders.add(order);
    }

    public void setStatus(boolean status) {
        this.activeStatus = status;
    }

    public int getBillID() {
        return billID;
    }

    public void addDiscount(double amount) {

    }

    public void pay(double amount) {

    }


    public void checkFirstOrder() {
        if (this.orders == null) {
            System.out.println("IM EMPTY");
        }
    }
}
