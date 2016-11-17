/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arena.tournament;

/**
 *
 * @author S153977
 */
public class TournamentScore 
{
    private int score [];
    private int numberOfPlayers;
    public TournamentScore(int numberOfPlayers)
    {
        this.numberOfPlayers = numberOfPlayers;
        score = new int[numberOfPlayers];
        for(int i=0; i< numberOfPlayers; i++)
        {
            score[i] = 0;
        }
    }
    public void updateScore(int playerID, int points)
    {
        score[playerID]+= points;
    }
    public int getScore (int playerID)
    {
        return (score[playerID]);
    }
    public int getWinner()
    {
        int max = score[0];
        for (int i = 1; i < numberOfPlayers; i++)
        {
            if (score[i] > max)
            {
                max = score[i];
            }
        }
        return (max);
    }
}
