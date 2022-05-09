package com.myRestaurant;

public class UI {

    private final static String SPACING = "**********************************************";


    public void showMainMenu() {
        System.out.println(SPACING);
        System.out.println("*    RESTAURANT NAME HERE                    *");
        System.out.println("*    1. Order                                *");
        System.out.println("*    2. Menu                                 *");
        System.out.println("*    3. Check current table availability     *");
        System.out.println("*    4. Sales Records                        *");
        System.out.println(SPACING);
        System.out.println("*    Select your option:                     *");

    }

    public void showMenuPage() {
        System.out.println(SPACING);
        System.out.println("*    MENU PAGE                               *");
        System.out.println("*    1. Display available menu's             *");
        System.out.println("*    2. Display current menu                 *");
        System.out.println("*    3. Change menu's                        *");
        System.out.println("*    4. Go back to the main page             *");
        System.out.println(SPACING);
        System.out.println("*    Select your option:                     *");
    }
    public void showDrinksPage() {
        System.out.println(SPACING);
        System.out.println("*    DRINKS PAGE                             *");
        System.out.println(SPACING);
        System.out.println("*    Select your option or 0 to cancel order:*");
    }
}

