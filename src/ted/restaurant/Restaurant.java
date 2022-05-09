/*
 * Copyright (c) 2022. Ted Sprengers
 */

package ted.restaurant;

import database.DatabaseExec;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Restaurant
{
    //Connection conn;
    Restaurant ()
    {
      //  conn = Connectie.getConnection();

    }
    public void makeManu() throws SQLException
    {
        ResultSet rs = DatabaseExec.getResultset("land");
        while(rs.next())
        {
            int empNum = rs.getInt(1);
            String lastName = rs.getString("C_LAND");
            lastName = rs.getString("nm_land");
            lastName = rs.getString("C_ISO_3166_ALPHA_2");
            lastName = rs.getString(4);
            lastName = rs.getString(5);

        }
    }
}
