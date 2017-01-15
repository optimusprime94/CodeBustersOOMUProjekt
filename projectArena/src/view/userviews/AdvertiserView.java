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
import view.advertisement.CheckAccountBalanceView;
import view.advertisement.DefineAdvertisementSchemeView;
import view.advertisement.HandleAdvertisementView;

/**
 *
 * @author S143522
 */
public class AdvertiserView extends ArenaView{

    /* superclass references */
    private MenuBar menubar;
    private BorderPane arenaframe;
    /* operator attributes */
    private Menu options;
    private MenuItem checkBalance;
    private MenuItem handleAdvertisement;
    private MenuItem defineAdvertisementScheme;


    
    
    /* Constructor: with params: username, stage */
    public AdvertiserView(String username, Stage stage) {
        super(stage);
        super.username = username;
        this.menubar = super.menubar;
        this.arenaframe = super.arenaframe;
        options = new Menu("Advertisement options");
        checkBalance = new MenuItem("Check Account Balance");
        handleAdvertisement = new MenuItem("Handle Advertisement");
        defineAdvertisementScheme= new MenuItem("Define Advertisement Scheme");
        

        /* on action creates the check account balance view */
        checkBalance.setOnAction(e->{
            CheckAccountBalanceView checkAccountBalanceView = new CheckAccountBalanceView(arenaframe, username);
        });
        /* handle adverisement view */
        handleAdvertisement.setOnAction(e->{
            HandleAdvertisementView handleAdvertisement = new HandleAdvertisementView(arenaframe);
        });
        /* view for defining the scheme */
        defineAdvertisementScheme.setOnAction(e->{
            DefineAdvertisementSchemeView defineAdvertisementScheme = new DefineAdvertisementSchemeView(arenaframe);
        });     
        
        LogoutMenu();
        initOperatorOptions();
    }
    
    /**
     * adds the operations for an operator
     */
    private void initOperatorOptions(){
        
        options.getItems().addAll(checkBalance);
        options.getItems().addAll(handleAdvertisement);
        options.getItems().addAll(defineAdvertisementScheme);

        menubar.getMenus().addAll(options);
    }
    
}
