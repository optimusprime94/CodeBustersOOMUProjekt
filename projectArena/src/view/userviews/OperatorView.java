package userviews;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.ArenaView;
import view.administration.HandleGameView;
import view.administration.InstallGameView;
import view.administration.TournamentStyleView;

/**
 *
 * @author S143522
 */
public class OperatorView extends ArenaView{

    /* superclass referenser */
    private MenuBar menubar;
    private BorderPane arenaframe;
    /* operator attribut */
    private Menu options;
    private MenuItem handleGames, handleTournaments, handleUsers;
    
    
    /* konstruktor: med användarnamn som parameter */
    public OperatorView(String username, Stage stage) {
        super(stage);
        super.username = username;
        this.menubar = super.menubar;
        this.arenaframe = super.arenaframe;
        options = new Menu("Administration");
        handleGames = new MenuItem("Handle Games");
        handleTournaments = new MenuItem("Handle Tournaments");
        handleUsers = new MenuItem("Handle Arena Users");
        
        handleGames.setOnAction(e->{
            HandleGameView handleGame = new HandleGameView(arenaframe);
            handleGame.show();
        });        
        handleTournaments.setOnAction(e->{
            TournamentStyleView handleTournament = new TournamentStyleView(arenaframe);
        });
        handleUsers.setOnAction(e-> {
            HandleUsersView handleUsers = new HandleUsersView(arenaframe);
        });
        LogoutMenu();
        initOperatorOptions();
    }
    
    private void initOperatorOptions(){
        
        options.getItems().addAll(handleGames, handleTournaments, handleUsers);
        menubar.getMenus().addAll(options);
    }
    
}
