package com.myRestaurant;

import com.myRestaurant.controllers.DbController;
import com.myRestaurant.controllers.MenuController;
import com.myRestaurant.controllers.OrderController;
import com.myRestaurant.entities.Restaurant;

import java.util.Scanner;

public class Main {
    // had to make all of these static in order to be able to go back to the main menu (option 4 from menuController)
    // if i didnt, a new restaurant object would be recreated everytime i went back to the main page (run()) and all the options would be reset.
    static DbController dbController = new DbController();
    static Restaurant myRestaurant = new Restaurant(10, dbController.loadMenuItems());
    static MenuController menuController = new MenuController(myRestaurant);
    static OrderController orderController = new OrderController(myRestaurant, menuController);

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        UI ui = new UI();
        ui.showMainMenu();

        int input = scanner.nextInt();
        switch (input) {
            case (1) -> {
                // this should show available tables, the option to select the current table for a customer and show the current menu and allow ordering of menuItems.
                System.out.println("selected order");
                orderController.orderMode();
            }
            case (2) -> {
                // this should show the available menu's and allow you to change menu's.
                System.out.println("selected menu");
                menuController.menuOptions();
            }
            case (3) -> {
                // this should display all tables including their availability.
                System.out.println("Displaying Table Status:");
                myRestaurant.printAllTables();
                run();
            }
            // TODO this should ask for a time period and show you the sales in that period.
            case (4) -> {
                System.out.println("selected sales records");
                System.out.println("Nothing here yet, go back");
                run();
            }

            default -> System.out.println("Please choose a valid option.");
        }
    }
}
