/*
 * Copyright (c) 2022. Ted Sprengers
 */

package ted.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.Connectie.conn;

public class DatabaseExec
{
    public static ResultSet getResultset(String tablename) throws SQLException
    {
        return getResultset(tablename, null, null);
    }


    public static ResultSet getResultset(String tablename, String where) throws SQLException
    {
        return getResultset(tablename, where, null);
    }

    public static ResultSet getResultset(String tablename, String where, String order) throws SQLException
    {
        conn = Connectie.getConnection();
        // Creating prepared Statement
        PreparedStatement pstatemnt =
                conn.prepareStatement("Select * from " + tablename
                        + (where==null ? "" : " " + where)
                        + (order==null ? "" : " " + order),
                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return pstatemnt.executeQuery();
    }

    public static ResultSet getRecord(String tablename, String key, String keyValue) throws SQLException
    {

        return getRecord(tablename," where " + key + " = '" + keyValue +"'" );
    }

    public static ResultSet getRecord(String tablename, String key, Integer keyValue) throws SQLException
    {
        return getRecord(tablename," where " + key + " = " + keyValue);
    }

    public static ResultSet getRecord(String tablename, String where) throws SQLException
    {
        conn = Connectie.getConnection();
        // Creating prepared Statement
        PreparedStatement pstatemnt =
                conn.prepareStatement("Select * from " + tablename +  " where " + where,
                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return pstatemnt.executeQuery();
    }

}
