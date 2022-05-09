package com.myRestaurant.database;

public class Database {

    static final String DB_URL = "jdbc:mysql://localhost:3306/bppdatabase";
    static final String USER = "Oefenacc";
    static final String PASSWORD = "Oefenacc";


    /* public void insert() {
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO `customers` (customername, customernumber) VALUES ('Htest', '0610633434469');";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
}


