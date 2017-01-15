/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.administration;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author S143534
 */
public class TournamentStyleView {

    GridPane grid = new GridPane(); //skapar listan för alla tournaments.
    private BorderPane framepane;

    public TournamentStyleView(BorderPane framepane) {
        this.framepane = framepane;
        dispayTournaments();
        this.framepane.setCenter(grid);

    }
    /**
     * disp
     */
    private void dispayTournaments() {
        /* Behöver hämta en lista med namn och status på alla tournaments.
         * för att kunna visa operator, och knapp för att ändra status.
         */
        TournamentsList tList = new TournamentsList();
        ArrayList tNames = tList.getTournamentsName();
        ArrayList tStatus = tList.getTournamentsStatus();

        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);
        for (int i = 0; i < tNames.size(); i++) {
            Label statusText = new Label((String) tNames.get(i));
            Button btActivate = new Button("Activate");
            Button btDeactivate = new Button("Deactivate");

            grid.add(statusText, 1, i);
            grid.add(btActivate, 2, i);
            grid.add(btDeactivate, 3, i);

            btActivate.setOnAction(e -> {
                System.out.println("Actived");
                /* här borde då statusen uppdateras och skickas vidare för att sparas permanent i databasen. */
                //HandleTournamentStyle handle = new HandleTournamentStyle(i, 1);
                // handle.activate
            });
            btDeactivate.setOnAction(e -> {
                System.out.println("Deactivated");
                /* här borde då statusen uppdateras och skickas vidare för att sparas permanent i databasen. */
                //HandleTournamentStyle handle = new HandleTournamentStyle(i, 1);
                // handle.activate
            });
        }
    }

}
