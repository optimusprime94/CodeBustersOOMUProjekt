/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.league;

import java.sql.*;

import java.util.ArrayList;
import model.advertisement.Advertisement;


/**
 *
 * @author S153977
 */
public class DatabaseManager 
{
    private ArrayList<String> gamesLibrary;
    private ArrayList<String> tournaments;
    private ArrayList<Advertisement> adverts;
    
    public DatabaseManager()
    {
        this.gamesLibrary = new ArrayList<>();
        this.tournaments = new ArrayList<>(); 
        this.adverts = new ArrayList<>(); 
    }
    
    public ArrayList getGames()
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String message = ("select* from gameLibrary");
            ResultSet resultSet = statement.executeQuery(message);

            while (resultSet.next()) 
            {
                this.gamesLibrary.add(resultSet.getString(2));
            } 
        }
        catch(Exception ex)
        {
            System.out.print(ex.getMessage());
        }
        return(gamesLibrary);
    }
    public ArrayList getTournaments()
    {
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
                    this.tournaments.add(name);
                }    
            }
        }
        catch(Exception ex)
        {
            System.out.print(ex.getMessage());
        }
        return(tournaments);
    }
    public ArrayList getAdverts()
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String message= "select* from adverts";
            ResultSet resultSet = statement.executeQuery(message);
            while (resultSet.next())
            {
                String filePath = resultSet.getString(2);
                String timeLenth = resultSet.getString(3);
                String url = resultSet.getString(4);
                Advertisement advert = new Advertisement(filePath, timeLenth, url);
                adverts.add(advert); 
            }
        }
        catch(Exception ex)
        {
            System.out.print(ex.getMessage());
        }
        return(adverts);
    }
    public void saveTournament(Tournament tournament)
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String message = "insert into activeTournaments values("+tournament.getNumberOfPlayers()+", "
                    + ""+tournament.getMaxNrOfPlayers()+",' "+tournament.getName()+"', '"+tournament.getGameName()+"')";
            statement.executeUpdate(message);
        }
        catch(Exception ex)
        {
            System.out.print(ex.getMessage());
        }
    }
}
