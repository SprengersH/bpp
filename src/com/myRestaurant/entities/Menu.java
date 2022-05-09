package com.myRestaurant.entities;

import java.util.ArrayList;
import java.util.List;

// at the moment this class doesnt do anything yet as the menuNumber is embedded in each menuItem.

public class Menu {

    private int menuNumber;
    private List<MenuItem> menuItemList;

    public Menu(int menuNumber) {

        this.menuNumber = menuNumber;
        this.menuItemList = new ArrayList<>();
    }
}
