/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.userviews;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.ArenaView;
import model.league.OrganizeTournamentView;

/**
 *
 * @author S143522
 */
public class LeagueOwnerView extends ArenaView{

    /* superclass references */
    private MenuBar menubar;
    private BorderPane arenaframe;
    /* operator attributes */
    private Menu options;
    private MenuItem createTournament;
   
    
    
    /* konstruktor: med användarnamn som parameter */
    public LeagueOwnerView(String username, Stage stage) {
        super(stage);
        super.username = username;
        this.menubar = super.menubar;
        this.arenaframe = super.arenaframe;
        options = new Menu("League Owner Options");
        createTournament = new MenuItem("Create Tournament");

        createTournament.setOnAction(e->{
            OrganizeTournamentView createTournamentView = new OrganizeTournamentView(arenaframe);
            
            createTournamentView.show();
            
        });
    
        LogoutMenu(); // adds the logout menu.
        initLeagueOwnerOptions();
    }
    
    /**
     * adds the options for league owner to menu.
     */
    private void initLeagueOwnerOptions(){
        
        options.getItems().addAll(createTournament);
        menubar.getMenus().addAll(options);
    }
    
}
