/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.league;
import java.util.*;
import model.users.Player;

/**
 *
 * @author S153977
 */
public class EleminationScheme {
    private Queue<Player> queue;
    
    public EleminationScheme()
    {
        this.queue = new LinkedList<Player>();
    }
    public Player[] getNextPlayers()
    {
        Player[] players = new Player[2];
        players[0] = queue.remove();
        players[1] = queue.remove();
        return (players); 
    }
    public boolean matchesExists()
    {
        if (queue.size() == 1)
        {
            return false;
        }
        return (true);
    }
    public void update(Player winner)
    {
        queue.add(winner);
    }
    public void addPlayers(Player players[])
    {
        for (int i=0; i < players.length; i++)
        {
            queue.add(players[i]);
        }
    }
}
