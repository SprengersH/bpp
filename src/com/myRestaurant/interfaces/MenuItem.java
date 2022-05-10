package com.myRestaurant.interfaces;

public interface MenuItem {

    int getMenuNumber();

    String getCourseType();

    int getMenuItemID();

    double getPrice();

    String getName();

    String getDescription();

    @Override
    String toString();
}
