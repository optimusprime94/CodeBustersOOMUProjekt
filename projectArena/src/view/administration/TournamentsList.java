/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.administration;

import java.util.ArrayList;

/**
 *
 * @author S143534
 */
public class TournamentsList {

    public ArrayList getTournamentsName() {
        ArrayList tournamentNames = new ArrayList();
        tournamentNames.add("Elimination");
        tournamentNames.add("Team Deathmatch");
        tournamentNames.add("Free for all");
        tournamentNames.add("Generic");
        return tournamentNames;
    }

    public ArrayList getTournamentsStatus() {
        ArrayList tournamentStatus = new ArrayList();
        tournamentStatus.add("Active");
        tournamentStatus.add("Active");
        tournamentStatus.add("Active");
        tournamentStatus.add("Active");
        return tournamentStatus;
    }

}
