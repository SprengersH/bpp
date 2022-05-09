package com.company;


import com.database.DBCustomer;

import java.time.LocalDate;

import java.util.List;


public class Restaurant {

    private String name;
    private int capacity;
    private int opensAt;
    private int closesAt;
    private LocalDate openingHours;
    private List<Table> tableList;
    private List<Customer> customerList;

    public Restaurant(String name, int capacity, int opensAt, int closesAt) {
        this.name = name;
        this.capacity = capacity;
        this.opensAt = opensAt;
        this.closesAt = closesAt;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    private void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public void getAllCustomersFromDB() {
        DBCustomer dbc = new DBCustomer();
        setCustomerList(dbc.getAllCustomers());
    }


    public boolean isOpen(LocalDate datetime) {
        return true;
    }

    public boolean checkAvailability(LocalDate datetime) {
        return true;
    }

    public void addTable(int id) {

    }
    public void removeTable(int id) {

    }

}
