package com.myRestaurant.database;


import com.myRestaurant.entities.MenuItem;
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
                                rs.getInt("menunumber"),
                                rs.getString("coursetype"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getDouble("price"));
                allMenuItemsList.add(menuItem);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allMenuItemsList;
    }


    public ArrayList<MenuItem> selectMenu(int menunumber) {

        String query = "SELECT * FROM menuitem WHERE menunumber = ?";
        ArrayList<MenuItem> MenuList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            // Bind value into the statement at parameter index 1.
            stmt.setInt(1, menunumber);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                MenuItem menuItem = new MenuItem
                        (rs.getInt("menuitemid"),
                                rs.getInt("menunumber"),
                                rs.getString("coursetype"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getDouble("price"));
                MenuList.add(menuItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return MenuList;
    }

}
