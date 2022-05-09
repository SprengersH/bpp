/*
 * Copyright (c) 2022. Ted Sprengers
 */

package ted.restaurant;


import algemeen.StringTools;
import database.Connectie;
import java.sql.Connection;
import java.sql.SQLException;

public class RunRestaurant
{
    Connection conn;

    public RunRestaurant(String[] args)
    {
        try
        {
            Connectie.openConnection(StringTools.getParameter(args, "dbUrl"), StringTools.getParameter(args, "user"), StringTools.getParameter(args, "password"));
            conn = Connectie.getConnection();
            Restaurant restaurant = new Restaurant();
            restaurant.makeManu();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }



    static public void main(String[] args)
    {

        String[] argsEigen = args;
        if (args.length < 1)
        {
            argsEigen = new String[]
                    {
                         "dbUrl=jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(Host = database1)(Port = 1521)) (CONNECT_DATA = (SERVICE_NAME = dzfd2201)))",
                         "user=mdc",
                         "password=mdcpwd"
                    };
        }

        new RunRestaurant(argsEigen);

    }

}
