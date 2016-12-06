/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.league;

/**
 *
 * @author S153977
 */
public class Score {
    
    private int [] scoreTable;
    
    public Score(int players)
    {
        this.scoreTable = new int[players];
    }
    public int getScore(int playerID)
    {
        return scoreTable[playerID];
    }
    public void update(int playerID, int score)
    {
        scoreTable[playerID] =+ score;
    }
}
