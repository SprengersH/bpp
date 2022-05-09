package com.myRestaurant.controllers;

import com.myRestaurant.UI;
import com.myRestaurant.entities.Restaurant;

import java.util.Scanner;

public class OrderController {

    private Restaurant myRestaurant;
    private Scanner scanner = new Scanner(System.in);
    private MenuController menuController;
    UI ui = new UI();

    public OrderController(Restaurant myRestaurant, MenuController menuController) {
        this.myRestaurant = myRestaurant;
        this.menuController = menuController;

    }

    public void orderMode() {
        myRestaurant.printAvailableTables();
        System.out.println("Select tablenumber:");
        int tableNumber = scanner.nextInt();
        myRestaurant.setUnavailable(tableNumber);
        menuController.printDrinks();
    }
}
