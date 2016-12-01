/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.administration;

import model.exceptions.GameIDNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;



/**
 *
 * @author Nick
 */
public class HandleGame
{
    public HandleGame() {}
   
    public void installNewGame(Game newGame)
    {
        try{
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
        }
        catch (SQLException ex)
        {
            System.out.print(ex.getMessage());
        } 
    }
    public void deleteGame(int id)
    {
        try
        {
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
        Statement statement = connection.createStatement();
        String SQLMessage = "delete from gameLibrary where gameID = "+id+";";
        statement.executeUpdate(SQLMessage);
        connection.close();
        }
        catch (SQLException ex)
        {
            System.out.print(ex.getMessage());
        }
    }
    public void deleteGame(Game game)
    {
        int gameID = game.getGameId();
        deleteGame(gameID);
    }
}
