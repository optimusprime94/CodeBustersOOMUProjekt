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
    public static void AddAdvertisment(Advertisement newAd)
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
}
