/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameinstaller;

import exceptions.GameIDNotFoundException;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Nick
 */
public class Library {
    private ArrayList<Game> gamesLibrary;
    private int size;   
    
    public Library(){
        gamesLibrary = new ArrayList<>();
        size = 0;
    }
    
    public void initializeLibrary() throws SQLException{
        try
        {
            updateLibrary();
        }
        catch (SQLException ex)
        {
            System.out.print(ex.getMessage());
        }
    }
    
    public void updateLibrary() throws SQLException
    {
        size = 0;
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
        Statement statement = connection.createStatement();
        String message= "select* from gameLibrary";
        ResultSet resultSet = statement.executeQuery(message);
        while (resultSet.next())
        {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String visibility = resultSet.getString(3);
            String gamePath = resultSet.getString(4);
            String imagePath = resultSet.getString(5);
            Game game = new Game(id, name, visibility, gamePath, imagePath);
            gamesLibrary.add(game);
            size++;
        }
        connection.close();
    }
    
    public void installNewGame(Game newGame) throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
        Statement statement = connection.createStatement();
       
        String gameName = newGame.getGameName();
        int visibility =0;
        if (newGame.getGameVisibility())
        {
            visibility = 1;
        }
        String gamePath = newGame.getGamePath();
        String imagePath = newGame.getImagePath();
        String SQLMessage = "insert into gameLibrary (gameName, visibility, gamePath, imagePath) VALUES ('"+gameName+"', "+visibility+", '"+gamePath+"', '"+imagePath+"');";
        statement.executeUpdate(SQLMessage);
        connection.close();
         try
        {
            updateLibrary();
        }
        catch (SQLException ex)
        {
            System.out.print(ex.getMessage());
        } 
    }
    
    public void deleteGame(Game gameToBeDeleted) throws SQLException{
        
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
        Statement statement = connection.createStatement();
        int id = gameToBeDeleted.getGameId();
        String SQLMessage = "delete from gameLibrary gameID = "+id+";";
        statement.executeUpdate(SQLMessage);
        connection.close();
        try
        {
            updateLibrary();
        }
        catch (SQLException ex)
        {
            System.out.print(ex.getMessage());
        }
    }
    public Game getGame(int id) throws GameIDNotFoundException
    {
        for(int i = 0; i < size; i ++)
        {
            if (gamesLibrary.get(i).getGameId() == id)
            {
                return(gamesLibrary.get(i));
            }
        }
        throw new GameIDNotFoundException(id);
    }
}