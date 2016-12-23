/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.advertisement;

import java.sql.*;
import java.util.ArrayList;



/**
 *
 * @author S153977
 */
public class GetAdvertisement {
    private ArrayList<Advertisement> adverts;
    
   public GetAdvertisement()
   {
       this.adverts = new ArrayList<>();
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String message= "select* from Adverts";
            ResultSet resultSet = statement.executeQuery(message);
            while (resultSet.next())
            {
                String filePath = resultSet.getString(2);
                String time = resultSet.getString(3);
                String url = resultSet.getString(4);
                Advertisement advert = new Advertisement(filePath, time, url);
                adverts.add(advert);  
            }
        }
        catch(Exception ex)
        {
            System.out.print(ex.getMessage());
        }
   }
   public ArrayList<Advertisement> getAdverts ()
   {
       return (adverts);
   }
}
