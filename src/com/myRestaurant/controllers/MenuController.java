package com.myRestaurant.controllers;

import com.myRestaurant.Main;
import com.myRestaurant.UI;
import com.myRestaurant.entities.Restaurant;

import java.util.Scanner;

public class MenuController {

    private Restaurant myRestaurant;
    private Scanner scanner = new Scanner(System.in);
    private int currentMenu;
    UI ui = new UI();



    public MenuController(Restaurant myRestaurant) {
        this.myRestaurant = myRestaurant;
        this.currentMenu = 1; //default menu is menu 1.
    }


    public void printMenu() {
        myRestaurant.printMenu(this.currentMenu);
    }

    //public void loadMenu(int menuNumber) {
        // this might cycle through all the menuItems and put them into different Lists of menu's.
        // at the moment the menuNumber(to which menu it belongs(summer,winter etc)) is embedded in each menuItem.
        //Menu menu = new Menu(1);
    //}

    public void menuOptions() {
        ui.showMenuPage();
        int input = scanner.nextInt();
        switch (input) {
            case (1) -> {
                // TODO this should show the contents of the current menu with courses etc.
                System.out.println("selected 1");
                System.out.println("this doesnt do anything yet");
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

    public void printDrinks() {
    }
}
