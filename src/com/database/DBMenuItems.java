package com.database;

import com.company.MenuItem;

import java.sql.*;
import java.util.ArrayList;

public class DBMenuItems extends Database {

    public ArrayList<MenuItem> selectAllMenuItems() {

        String query = "SELECT * FROM menuitem";
        ArrayList<MenuItem> allMenuItemsList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(query);
        ) {

            while (rs.next()) {
                MenuItem menuItem = new MenuItem
                        (rs.getInt("menuitemid"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getDouble("price"));
                allMenuItemsList.add(menuItem);
                //Display values
                //System.out.print("ID: " + rs.getInt("menuitemid"));
                //System.out.print(", Name: " + rs.getString("name"));
                //System.out.print(", Description: " + rs.getString("description"));
                //System.out.println(", price: " + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // testloop to check if query and list works.
        // for (MenuItem item : allMenuItemsList) {
        //    System.out.println(item.toString());
        // }
        return allMenuItemsList;
    }


}
