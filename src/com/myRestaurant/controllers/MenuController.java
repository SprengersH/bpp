package com.myRestaurant.controllers;

import com.myRestaurant.view.Main;
import com.myRestaurant.view.UI;
import com.myRestaurant.entities.MenuItem;
import com.myRestaurant.entities.Restaurant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuController {

    private Restaurant myRestaurant;
    private List<MenuItem> menuItems;
    private Scanner scanner = new Scanner(System.in);
    private int currentMenu;
    UI ui = new UI();



    public MenuController(Restaurant myRestaurant, ArrayList<MenuItem> menuItems) {
        this.myRestaurant = myRestaurant;
        this.currentMenu = 1; // default menu is menu 1.
        this.menuItems = menuItems;
    }

    //public void loadMenu(int menuNumber) {
        // this might cycle through all the menuItems and put them into different Lists of menu's.
        // at the moment the menuNumber(to which menu it belongs(summer,winter etc.)) is embedded in each menuItem.
        //Menu menu = new Menu(1);
    //}

    public void menuOptions() {
        ui.showMenuPage();
        int input = scanner.nextInt();
        switch (input) {
            case (1) -> {
                // TODO this should show the contents of the current menu with courses etc.
                System.out.println("selected 1");
                System.out.println("this doesn't do anything yet");
                menuOptions();
            }
            case (2) -> {
                // this now shows the current selected menu. 1 by default.
                System.out.println("Displaying current menu:");
                printMenu();
                menuOptions();
            }
            case (3) -> {
                // this allows you to change between menu's.
                System.out.println("Changing menu's");
                System.out.println("Select new menu:");
                this.currentMenu = scanner.nextInt();
                menuOptions();
            }
            case (4) -> {
                System.out.println("Going back to the main page:");
                Main.run();
            }

            default -> System.out.println("Please choose a valid option.");
        }

    }

    public void printMenu() {
        for (MenuItem menuItem : menuItems) {
            if(menuItem.getMenuNumber() == this.currentMenu) {
                System.out.println(menuItem);
            }
        }
    }

    public void printCourse(String course) {

        for (MenuItem menuItem : menuItems) {
            if(menuItem.getCourseType().equalsIgnoreCase(course)) {
                System.out.println(menuItem);
            }
        }
    }
}
