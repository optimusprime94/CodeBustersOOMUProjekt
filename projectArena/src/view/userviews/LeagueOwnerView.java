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
import view.administration.HandleGameView;
import view.administration.InstallGameView;
import view.league.CreateTournamentView;

/**
 *
 * @author S143522
 */
public class LeagueOwnerView extends ArenaView{

    /* superclass referenser */
    private MenuBar menubar;
    private BorderPane arenaframe;
    /* operator attribut */
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
            CreateTournamentView createTournamentView = new CreateTournamentView(arenaframe);
            
            createTournamentView.show();
            
        });
        LogoutMenu();
        initOperatorOptions();
    }
    
    private void initOperatorOptions(){
        
        options.getItems().addAll(createTournament);
        menubar.getMenus().addAll(options);
    }
    
}
