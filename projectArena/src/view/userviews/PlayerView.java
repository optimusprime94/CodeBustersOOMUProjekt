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


/**
 *
 * @author S143522
 */
public class PlayerView extends ArenaView {

    /* superclass referenser */
    private MenuBar menubar;
    private BorderPane arenaFrame;
    
    /* operator attribut */
    private Menu libraryMenu;
    private MenuItem shopItem, gamesItem;
    private GameLibraryView gameLibrary;
    
    
    
    /* konstruktor: med användarnamn som parameter */
    public PlayerView(String username, Stage stage) {
        super(stage);
        super.username = username;
        this.menubar = super.menubar;
        this.arenaFrame = super.arenaframe;         //För simpelhetens skull
        gameLibrary = new GameLibraryView(arenaFrame);

        libraryMenu = new Menu("Library");
        /* skapar och sätter in items i gamesMenu. */
        shopItem = new MenuItem("Shop");
        gamesItem = new MenuItem("Games");

        initPlayerView();
    }

    private void initPlayerView() {

        libraryMenu.getItems().addAll(shopItem, gamesItem);
        menubar.getMenus().addAll(libraryMenu);

        gamesItem.setOnAction(event -> gameLibrary.showGameLibrary());
        shopItem.setOnAction(event -> System.out.println("SHOP"));
    }

}
