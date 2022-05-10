package com.myRestaurant.database;

import com.myRestaurant.entities.Order;

import java.sql.*;

public class DBOrders extends Database {

    public void insertOrder(Order order) {
        String query = "INSERT INTO `orders` (orderid, orderprice, tablenumber, active) VALUES (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             // Generate a prepared statement with the placeholder parameter.
             PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            // Bind value into the statement at parameter index 1,2,3.
            stmt.setString(1, order.getOrderID());
            stmt.setDouble(2, order.getPrice());
            stmt.setInt(3, order.getTableNumber());
            stmt.setInt(4, order.getActive());
            // Execute a query
            System.out.println("Inserting new order into the table...");
            stmt.executeUpdate();
            System.out.println("Inserted order into the ordertable...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOrderToProduct(String orderID, int productID, int tableNumber, int active) {
        String query = "INSERT INTO `order-product` (orderid, productid, tablenumber, active) VALUES (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             // Generate a prepared statement with the placeholder parameter.
             PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            // Bind value into the statement at parameter index 1,2,3,4.
            stmt.setString(1, orderID);
            stmt.setInt(2, productID);
            stmt.setInt(3, tableNumber);
            stmt.setInt(4, active);
            // Execute a query

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getOrderidFromTablenumber(int tableNumber) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        // Generate a prepared statement with the placeholder parameter.
        String query = "SELECT * FROM `orders` WHERE tablenumber = ? AND active = ?";
        PreparedStatement stmt = conn.prepareStatement(query);

        // Bind value into the statement at parameter index 1 etc.

        stmt.setInt(1, tableNumber);
        stmt.setInt(2, 1);
        ResultSet rs = stmt.executeQuery();
        // don't forget to execute the PrepareStatement without parameters (stmt.executeQuery(query))
        // or you will lose another 5 hours of your life.
        String orderID = "";
        while (rs.next()) {
             orderID = rs.getString("orderid");
        }
        return orderID;
    }
}
