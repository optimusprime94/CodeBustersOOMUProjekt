/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.league;

import model.administration.Game;
import model.advertisement.Advertisement;
import model.users.Player;

/**
 *
 * @author S153977
 */
public abstract class Tournament {
    protected int numberOfPlayers;
    protected int maxNumberOfPlayers;
    protected Player [] players;
    protected Advertisement advertisment;
    protected String name;
    protected Game game;
    
    public Player getWinner()
    {
        return (new Player());
    }
    public boolean applyForTournament(Player player)
    {
        if (maxNumberOfPlayers == numberOfPlayers)
        {
            return (false);
        }
        players[numberOfPlayers] = player;
        return true;
    }
    public void addAdvert(Advertisement advertisment)
    {
        this.advertisment = advertisment;
    }
    public abstract void conductTournament();
    
    public int getNumberOfPlayers()
    {
        return (numberOfPlayers);
    }
    public int getMaxNrOfPlayers()
    {
        return(maxNumberOfPlayers);
    }
    public String getName()
    {
        return(name);
    }
    public String getGameName()
    {
        return(game.getGameName());
    }
   
}
