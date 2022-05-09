package com.company;

import com.database.DBCustomer;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Customer {

    Scanner scanner = new Scanner(System.in);

    private String name;
    private int customerID;
    private String contactNumber;
    private LocalDate lastVisited;
    private List<Bill> bills;


    public Customer(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.lastVisited = LocalDate.now();
    }

    public Customer(String name, int customerID, String contactNumber, LocalDate lastVisited) {
        this.name = name;
        this.customerID = customerID;
        this.contactNumber = contactNumber;
        this.lastVisited = lastVisited;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setLastVisited(LocalDate lastVisited) {
        this.lastVisited = lastVisited;
    }

    public LocalDate getLastVisited() {
        return lastVisited;
    }

    /*public Customer findReturningCustomer() {
        String name = this.name;
        // code to separate lastname from firstname or something
        selectWhere(name);
        return this;
    }*/

    public void addToDatabase(String name, String contactNumber) {
        DBCustomer db = new DBCustomer();
        db.addCustomerToDatabase(name, contactNumber, lastVisited);
    }


    public int getNewCustomer(String name, String contactNumber) {
        DBCustomer dbc = new DBCustomer();
        int customerID = 0;

        try {
            customerID = dbc.retrieveNewCustomer(name, contactNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", customerID=" + customerID +
                ", contactNumber='" + contactNumber + '\'' +
                ", lastVisited=" + lastVisited +
                '}';
    }
}
