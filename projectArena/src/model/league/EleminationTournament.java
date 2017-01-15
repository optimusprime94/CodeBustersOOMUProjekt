/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.league;

import model.administration.Game;
import model.play.PlayMatch;
import model.users.Player;

/**
 *
 * @author S153977
 */
public class EleminationTournament extends Tournament
{
    
    private EleminationScheme scheme;
    private Score score;
  
    public EleminationTournament(int maxPlayers, Game game, String name)
    {
        this.players = new Player[maxPlayers];
        this.maxNumberOfPlayers = maxPlayers;
        this.scheme = new EleminationScheme();
        this.score = new Score(maxPlayers);
        this.game = game;
        this.name = name;
        
    }
    @Override
    public void conductTournament()
    {
        if (this.maxNumberOfPlayers == this.numberOfPlayers)
        {
            scheme.addPlayers(players);
            while (scheme.matchesExists())
            {
                Player[] nextPlayers = scheme.getNextPlayers();
                PlayMatch match = new PlayMatch(game, nextPlayers[0], nextPlayers[1]);
                System.out.print("");
                //notifyGameReady(nextPlayers[0], match);
                //notifyGameReady(nextPlayers[1], match);
            }
        }
    }    
}
