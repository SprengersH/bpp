package com.myRestaurant.entities;


import java.util.List;

// could bill implement an interface like Payable???
public class Bill {

    private int tableNumber;
    private String orderID;
    private double totalBillPrice;
    private List<MenuItem> itemToBill;


    public Bill(int tableNumber, String orderID, List<MenuItem> itemToBill) {
        this.tableNumber = tableNumber;
        this.orderID = orderID;
        for (MenuItem item : itemToBill) {
            this.totalBillPrice += item.getPrice();
        }
        this.itemToBill = itemToBill;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "tableNumber=" + tableNumber +
                ", orderID='" + orderID + '\'' +
                ", totalBillPrice=" + totalBillPrice +
                ", itemToBill=" + itemToBill +
                '}';
    }
}

