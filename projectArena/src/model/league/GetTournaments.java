/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.league;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author S153977
 */
public class GetTournaments {
    
    private ArrayList<String> tournaments;
    public GetTournaments()
    {
       this.tournaments = new ArrayList<>();
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String message= "select* from tournament";
            ResultSet resultSet = statement.executeQuery(message);
            while (resultSet.next())
            {
                String name = resultSet.getString(2);
                int visibility = Integer.parseInt(resultSet.getString(3));
                if (visibility == 1)
                {
                    tournaments.add(name);
                }    
            }
        }
        catch(Exception ex)
        {
            System.out.print(ex.getMessage());
        }
    }
    public ArrayList<String> getTournaments()
    {
        return (tournaments);
    }
}
