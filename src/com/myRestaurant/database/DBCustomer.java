package com.myRestaurant.database;

import com.company.Customer;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBCustomer extends Database {

    public void addCustomerToDatabase(String name, String contactNumber, LocalDate lastVisited) {
        String query = "INSERT INTO `customers` (customername, customernumber, lastvisited) VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             // Generate a prepared statement with the placeholder parameter.
             PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            // Bind value into the statement at parameter index 1,2,3.
            stmt.setString(1, name);
            stmt.setString(2, contactNumber);
            stmt.setDate(3, Date.valueOf(lastVisited));
            // Execute a query
            System.out.println("Inserting new customer into the table...");
            stmt.executeUpdate();
            System.out.println("Inserted customer " + name + " into the customertable...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {

        List<Customer> customerList = new ArrayList<>();
        String query = "SELECT * FROM customers";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(query);
        ) {
            while (rs.next()) {

                //Display values
                String name = rs.getString("customername");
                int customerID = rs.getInt("idcustomers");
                String number = rs.getString("customernumber");
                Date lastVisitedSql = rs.getDate("lastvisited");
                LocalDate lastVisited = lastVisitedSql.toLocalDate();
                Customer customer = new Customer(name, customerID, number, lastVisited);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public void update() {

        String query = "UPDATE customers SET customername = 'updatedname' WHERE idcustomers = 1";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(query);
            getAllCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        String query = "DELETE FROM customers WHERE idcustomers > 7";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(query);
            getAllCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchName(String name) throws SQLException {

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        // Generate a prepared statement with the placeholder parameter.
        String query = "SELECT * FROM customers WHERE customername LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(query);

        // Bind value into the statement at parameter index 1.

        stmt.setString(1, name + "%");
        ResultSet rs = stmt.executeQuery();
        // don't forget to execute the PrepareStatement without parameters (stmt.executeQuery(query))
        // or you will lose another 5 hours of your life.


        while (rs.next()) {
            //Display values
            System.out.print("ID: " + rs.getInt("idcustomers"));
            System.out.print(", Name: " + rs.getString("customername"));
            System.out.print(", Number: " + rs.getString("customernumber"));
            System.out.println(", Last visited: " + rs.getDate("lastvisited"));

        }
    }

    public void selectOneMore(String name) {
        String query = "SELECT * FROM customers WHERE customername = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             // Generate a prepared statement with the placeholder parameter.
             PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            // Bind value into the statement at parameter index 1.
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            // don't forget to execute the PrepareStatement without parameters (stmt.executeQuery(query)) or you will lose another 5 hours of your life.
            while (rs.next()) {
                //Display values
                System.out.print("ID: " + rs.getInt("idcustomers"));
                System.out.print(", Name: " + rs.getString("customername"));
                System.out.println(", Number: " + rs.getString("customernumber"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Customer getCustomerFromID(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        // Generate a prepared statement with the placeholder parameter.
        String query = "SELECT * FROM customers WHERE idcustomers LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(query);

        // Bind value into the statement at parameter index 1.

        stmt.setString(1, id + "%");
        ResultSet rs = stmt.executeQuery();
        // don't forget to execute the PrepareStatement without parameters (stmt.executeQuery(query))
        // or you will lose another 5 hours of your life.
        Customer customer = null;
        while (rs.next()) {
            //Display values
            System.out.print("ID: " + rs.getInt("idcustomers"));
            System.out.print(", Name: " + rs.getString("customername"));
            System.out.print(", Number: " + rs.getString("customernumber"));
            System.out.println(", Last visited: " + rs.getDate("lastvisited"));
            String name = rs.getString("customername");
            int customerID = rs.getInt("idcustomers");
            String number = rs.getString("customernumber");
            Date lastVisitedSql = rs.getDate("lastvisited");
            LocalDate lastVisited = lastVisitedSql.toLocalDate();
            customer = new Customer(name, customerID, number, lastVisited);
        }
        return customer;
    }

    public int retrieveNewCustomer(String name, String contactNumber) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        // Generate a prepared statement with the placeholder parameter.
        String query = "SELECT * FROM customers WHERE customername = ? AND customernumber = ?";
        PreparedStatement stmt = conn.prepareStatement(query);

        // Bind value into the statement at parameter index 1.

        stmt.setString(1, name);
        stmt.setString(2, contactNumber);
        ResultSet rs = stmt.executeQuery();
        // don't forget to execute the PrepareStatement without parameters (stmt.executeQuery(query))
        // or you will lose another 5 hours of your life.
        Customer customer = null;
        int customerID = 0;
        while (rs.next()) {

            name = rs.getString("customername");
            customerID = rs.getInt("idcustomers");
            String number = rs.getString("customernumber");
            Date lastVisitedSql = rs.getDate("lastvisited");
            LocalDate lastVisited = lastVisitedSql.toLocalDate();
            customer = new Customer(name, customerID, number, lastVisited);

        }
        return customerID;
    }
}

