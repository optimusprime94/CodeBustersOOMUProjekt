/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arena.users;

/**
 *
 * @author S153298
 */
public class Player extends User{
    private int tournamentID;
    public Player()
    {
        
    }
    public void setTournamentID(int tournamentID)
    {
        this.tournamentID = tournamentID;
    }
    public int getTournamentID()
    {
        return(tournamentID);
    }
}
