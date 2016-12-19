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
import view.league.CreateTournamentView;

/**
 *
 * @author S143522
 */
public class AdvertiserView extends ArenaView{

    /* superclass referenser */
    private MenuBar menubar;
    private BorderPane arenaframe;
    /* operator attribut */
    private Menu options;
    private MenuItem checkBalance;
    
    
    /* konstruktor: med användarnamn som parameter */
    public AdvertiserView(String username, Stage stage) {
        super(stage);
        super.username = username;
        this.menubar = super.menubar;
        this.arenaframe = super.arenaframe;
        options = new Menu("AdvertisementView");
        checkBalance = new MenuItem("Check Account Balance");

        checkBalance.setOnAction(e->{
            System.out.println("This function is not complete, so for now you have no money. Ha. Ha.");
        });
        LogoutMenu();
        initOperatorOptions();
    }
    
    private void initOperatorOptions(){
        
        options.getItems().addAll(checkBalance);
        menubar.getMenus().addAll(options);
    }
    
}
