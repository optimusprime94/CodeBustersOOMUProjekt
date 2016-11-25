/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arena.Match;

import arena.users.Player;
import java.util.Random;


/**
 *
 * @author S143534
 */
public class Match {

    Player[] players;
    int playerID;
    int matchID;
    Match match;

    public Match() {
        players = null;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
        System.out.println("");
    }

    public int getMatchID() {
        return matchID;
    }



}
