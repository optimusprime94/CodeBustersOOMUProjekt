/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arena.tournament;

import arena.users.Player;

/**
 *
 * @author S153977
 */
public abstract class Tournament 
{
    protected int numberOfPlayers, maxNumberOfPlayers, nextID;
    protected Player [] players;
    
    public abstract void runTournament();
    
    
    public void announce()
    {
        
    }
    
    public void archive()
    {
        
    }
    
    public void addAdert()
    {
        
    }
    public void applyForTournament(Player player)
    {
        if (numberOfPlayers< maxNumberOfPlayers)
        {
            player.setTournamentID(nextID);
            players[nextID] = player;
            numberOfPlayers++;
            nextID++;
        }
        
    } 
}
