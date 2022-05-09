package com.company;

import com.database.DBCustomer;
import com.database.DBMenuItems;

import java.sql.SQLException;
import java.util.Scanner;

public class UI {

    private final Scanner scanner = new Scanner(System.in);

    Restaurant restaurant = new Restaurant("PizzaPlace", 50, 8, 21);

    public void runRestaurant() {

        System.out.println("Welcome to the restaurant!");
        restaurant.getAllCustomersFromDB();
        createMenu(1);
        try {
            selectTypeOfCustomer();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void selectTypeOfCustomer() throws SQLException {

        System.out.println("[N]ew or [E]xisting customer?");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("N")) {
            newCustomer();
        } else if (input.equalsIgnoreCase("E")) {
            returningCustomer();
        } else {
            System.out.println("No valid input");
            selectTypeOfCustomer();
        }
    }

    private void newCustomer() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter contactnumber:");
        String contactNumber = scanner.nextLine();
        Customer customer = new Customer(name, contactNumber);
        customer.addToDatabase(name, contactNumber);
        // should this be done by a seperate method/class using args?
        restaurant.getAllCustomersFromDB();
        // view newly-made customer
        // System.out.println(customer);
        selectOrderOrView(customer.getNewCustomer(name, contactNumber));
    }
    private void returningCustomer() throws SQLException {
        // Find returning customer via database or a complete customerlist that was initialized at startup.
        // Below works but should have some validation/error handling (what if no customers found etc)
        System.out.println("Enter (part of) name:");
        String searchQuery = scanner.nextLine();
        DBCustomer dbc = new DBCustomer();
        try {
            dbc.searchName(searchQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Enter ID:");
        int id = scanner.nextInt();
        selectOrderOrView(id);
    }

    private void selectOrderOrView(int id) {

        System.out.println("To create an order press 'c', to view orders press 'v'.");
        String input = scanner.nextLine();
        input = scanner.nextLine();
        if (input.equalsIgnoreCase("c")) {
            System.out.println("You selected order-mode!");
            createBill(id);
            createOrder(id);
        } else if (input.equalsIgnoreCase("v")) {
            System.out.println("You selected view-mode");
            
            System.out.println("There is nothing here yet, under construction");
        } else {
            System.out.println("No valid input!");
            selectOrderOrView(id);
        }
    }

    private void createOrder(int id) {

        Order order = new Order(id);
        order.printOrder();

    }

    private void createBill(int customerID) {
        Bill bill = new Bill(customerID);
        bill.checkFirstOrder();

    }

    public void createMenu(int menuID) {
        // this should load all the menuitems from sql into the list of menuitems.

        DBMenuItems dbm = new DBMenuItems();
        Menu menu = new Menu(1, dbm.selectAllMenuItems());
        //menu.printThisMenu();


        /*Menu menu = new Menu(menuID);
        menu.addItemToMenu(1, "Pizza", "Hot Pizza", 12.48);
        menu.addItemToMenu(2, "Pizza2", "Spicy Pizza", 12.99);
        menu.printThisMenu();
         */
    }
}
