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
import java.io.FileNotFoundException;
import java.sql.*;

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
    /**
    * Constructor with only a Game to start with and creates a player 
    * @param game 
    */
    public Match(Game game) {
        this.game = game;
        player1 = new Player();
        Play();
    }
    /** 
     * Our contructor with 1 game and 2 players 
     * @param game
     * @param player1
     * @param player2 
     */
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
        System.out.println("\n"+matchID);
    }
    /**
    * getMatchID gets the ID for the match 
    * @return 
    */
    public int getMatchID() {
        return matchID;
    }
    /**
     * initizateMatch, initiate the match with 2 players
     *
     *  
     */
   protected void initiziateMatch(Player player1,Player player2){
       Random rn = new Random();
       int match = rn.nextInt(99999);
       
       player2 = findOpponent();
       matchID = match;
       setMatchID(matchID);
       System.out.println("player1: "+player1);
       System.out.println("player2: "+player2);
       
       

    
    }
   /**
    * Play, Main method for match, initiate the match and starts the game
    *
    */
   public void Play(){
   initiziateMatch(player1,player2);
   new GameStarter(game);
   }
   public void getWinner(Player player1){
       System.out.println("winner is: "+player1);
       
}
   public Player findOpponent(){
       Player player2;
       player2 = new Player();
   
       return player2;
   }

}
