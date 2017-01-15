/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.administration;

import model.exceptions.GameIDNotFoundException;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Nick
 */
public class Library {
    /* Attributes */
    private ArrayList<Game> gamesLibrary;
    private int size;   
    /* Constructor */
    public Library(){
        gamesLibrary = new ArrayList<>();
        size = 0;
    }
    /**
     * This method is a getter for games.
     * @return an list with all games.
     */
    public ArrayList getGameLibrary(){
        /* tömmer gamesLibrary innan den uppdateras med alla spel */
        if(!gamesLibrary.isEmpty())
            gamesLibrary.clear();
        this.selectLibrary();
        return this.gamesLibrary;
    }
    /**
     * selects the games from the database.
     */
    private void selectLibrary() 
    {
        size = 0;
        try
        {
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
        catch(Exception ex)
        {
            System.out.print(ex.getMessage());
        }
               
    }
    /**
     * Returns one game from the gamesLibrary, until
     * there are no games left
     * @param id
     * @return
     * @throws GameIDNotFoundException 
     */
    public Game getGame(int id) throws GameIDNotFoundException
    {
        this.selectLibrary();
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