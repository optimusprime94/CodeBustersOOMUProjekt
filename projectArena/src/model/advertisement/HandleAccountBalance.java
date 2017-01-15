/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.advertisement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * 
 */
public class HandleAccountBalance {
    /**
     * This function first checks if the advertiser is part of the database table,
     * adds the advertiser if not, and increases their account balance by the given amount
     * @param id
     * @param money 
     */
    public static void addFund(int id, int money)
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            HandleAccountBalance.checkifExists(id);
            String SQLMessage = "update advertiser set Cash = Cash + "+ money+" where ID = "+id+";";
            statement.executeUpdate(SQLMessage);
            connection.close();
        }
        catch (SQLException ex)
        {
            System.out.print(ex.getMessage());
        } 
    }

    /**
     * This function return the account balance of the given userid
     * @param id
     * @return 
     */
    public static int getBalance(int id) 
    {
        int balance = 0;
        try 
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String SQLMessage = "Select Cash from advertiser where id = " + id + "";
            ResultSet resultSet = statement.executeQuery(SQLMessage);
            while (resultSet.next()) 
            {
                balance = Integer.parseInt(resultSet.getString(1));
            }
            connection.close();
        } 
        catch (SQLException ex) 
        {
            System.out.print(ex.getMessage());
        }
        return(balance);
    }
    
    /**
     * This function checks if the userId exists in the table and 
     * adds it if it isn't
     * @param id 
     */
    private static void checkifExists(int id){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String SQLMessage = "Select* from advertiser where ID = " + id;
            ResultSet resultSet = statement.executeQuery(SQLMessage);
            if (!resultSet.next()){
                addToDatabase(id);
                connection.close();
            }
        } 
        catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }
    
    /**
     * This adds a user to the database table
     * @param id 
     */
    private static void addToDatabase(int id){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String SQLMessage = "INSERT INTO advertiser (ID, Cash)\n" + "VALUES (" + id + ", 0)";
             statement.executeUpdate(SQLMessage);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }
}
