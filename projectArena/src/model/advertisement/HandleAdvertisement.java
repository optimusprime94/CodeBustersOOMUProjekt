/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.advertisement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author S153298
 */
public class HandleAdvertisement {
    public static void addAdvertisment(Advertisement newAd)
    {
        try{
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
        Statement statement = connection.createStatement();
       
        String filePath = newAd.getFilePath();
        String url = newAd.getUrl();
        String time = newAd.getTime();
        String SQLMessage = "insert into Adverts (filePath, timeLenth, url) VALUES ('"+filePath+"', '"+time+"', '"+url+"');";
        statement.executeUpdate(SQLMessage);
        connection.close();
        }
        catch (SQLException ex)
        {
            System.out.print(ex.getMessage());
        } 
    }
        public static void deleteAdvertisment(int adId)
    {
        try{
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
        Statement statement = connection.createStatement();
       

        String SQLMessage = "DELETE from Adverts where id = " + adId;
        statement.executeUpdate(SQLMessage);
        connection.close();
        }
        catch (SQLException ex)
        {
            System.out.print(ex.getMessage());
        } 
    }
    public static void changeAdvertisementTime(String id, String time)
    {
        try{
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
        Statement statement = connection.createStatement();
       
        
        String SQLMessage = "UPDATE Adverts SET timeLenth = "+ time + " WHERE id = " + id;
        statement.executeUpdate(SQLMessage);
        connection.close();
        }
        catch (SQLException ex)
        {
            System.out.print(ex.getMessage());
        } 
    }
}
