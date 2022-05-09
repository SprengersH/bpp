/*
 * Copyright (c) 2022. Ted Sprengers
 */

package ted.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectie
{
    static Connection conn;

    static public void openConnection(String url, String user, String password) throws SQLException
    {
         conn = DriverManager.getConnection(url, user, password);
    }

    static public Connection getConnection()
    {
        return conn;
    }
}
