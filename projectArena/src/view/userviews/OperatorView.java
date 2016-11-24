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
import view.ArenaView;
import view.HandleGameView;
import view.InstallGameView;

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
    private MenuItem handleGames, handleTournaments;
    
    
    /* konstruktor: med användarnamn som parameter */
    public OperatorView(String username) {
        
        super.username = username;
        this.menubar = super.menubar;
        this.arenaframe = super.arenaframe;
        options = new Menu("Administration");
        handleGames = new MenuItem("Handle Games");
        handleTournaments = new MenuItem("Handle Torunaments");
        handleGames.setOnAction(e->{
            HandleGameView handleGame = new HandleGameView(arenaframe);
            handleGame.show();
            
        });
        
        initOperatorOptions();
    }
    
    private void initOperatorOptions(){
        
        options.getItems().addAll(handleGames, handleTournaments);
        menubar.getMenus().addAll(options);
    }
    
}
