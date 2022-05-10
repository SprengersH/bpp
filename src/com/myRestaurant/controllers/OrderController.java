package com.myRestaurant.controllers;

import com.myRestaurant.view.Main;
import com.myRestaurant.view.UI;
import com.myRestaurant.entities.MenuItem;
import com.myRestaurant.entities.Order;
import com.myRestaurant.entities.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderController {

    private Restaurant myRestaurant;
    private Scanner scanner = new Scanner(System.in);
    private MenuController menuController;
    private List<MenuItem> menuItems;

    private List<MenuItem> itemsToAdd;
    UI ui = new UI();

    public OrderController(Restaurant myRestaurant, MenuController menuController, ArrayList<MenuItem> menuItems) {
        this.myRestaurant = myRestaurant;
        this.menuController = menuController;
        this.itemsToAdd = new ArrayList();
        this.menuItems = menuItems;
    }

    public void orderMode() {
        myRestaurant.printAvailableTables();
        System.out.println("Select table number:");
        int tableNumber = scanner.nextInt();
        // todo validation that selected table is available.
        myRestaurant.setUnavailable(tableNumber);
        courseSelector();
        itemSelector(tableNumber);
    }

    private void courseSelector() {
        ui.showCourses();
        int input = scanner.nextInt();
        switch (input) {
            case (1) -> {
                ui.showDrinksPage();
                menuController.printCourse("DRINKS");

            }
            case (2) -> {
                ui.showMainCourses();
                menuController.printCourse("MAIN COURSE");

            }
            case (3) -> {
                ui.showSideDishes();
                menuController.printCourse("SIDE DISH");

            }
            case (4) -> {
                System.out.println("Going back to the main page:");
                Main.run();
            }

            default -> {
                System.out.println("Please choose a valid option.");
                courseSelector();
            }

        }
    }

    private void itemSelector(int tableNumber) {

        int input = scanner.nextInt();
        if (input < 1) {

            if (itemsToAdd.size() < 1) {
                System.out.println("No items selected, please enter at least 1 item.");
            } else {
                addToOrder(itemsToAdd, tableNumber);
            }

        } else {
            for (MenuItem menuItem : menuItems) {
                if (menuItem.getMenuItemID() == input) {
                    itemsToAdd.add(menuItem);
                }
            }
            itemSelector(tableNumber);
        }
    }


    private void addToOrder(List<MenuItem> itemsToAdd, int tableNumber) {
        Order order = new Order(tableNumber, itemsToAdd);

        addOrderToDatabase(order);
        itemsToAdd.clear();
    }

    private void addOrderToDatabase(Order order) {
        DbController dbc = new DbController();
        dbc.insertOrder(order);
    }


}

