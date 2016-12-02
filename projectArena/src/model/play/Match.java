/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.play;

import controller.GameStarter;
import model.users.Player;
import java.util.Random;
import model.administration.Game;


/**
 *
 * @author S143534
 */
public class Match {
    Player player,player1,player2;
    private final Game game;
    int playerID;
    int matchID;
    private Match match;

    public Match(Game game) {
        this.game = game;
        player1 = new Player();
        Play();
    }
    public Match(Game game, Player player1,Player player2){
        this.game = game;
        this.player1 = player1;
        this.player2 = player2;
        Play();
        
    }
    /**
    * setMatchID sets the ID of the game  
    * 
     */
    public void setMatchID(int matchID) {
        this.matchID = matchID;
        System.out.println(""+matchID);
    }

    public int getMatchID() {
        return matchID;
    }
   protected void initiziateMatch(Player player1,Player player2){
       
       matchID = 1;
       setMatchID(matchID);
       System.out.println("player1: "+player1);
       System.out.println("player1: "+player2); 
       

    
    }
   public void Play(){
   initiziateMatch(player1,player2);
   new GameStarter(game);
   }
   public void getWinner(Player player1){
       System.out.println("winner is: "+player1);
       
}


}
