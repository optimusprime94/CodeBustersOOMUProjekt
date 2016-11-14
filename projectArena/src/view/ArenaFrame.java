/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Elvir
 */
public class ArenaFrame {

    Stage stage;
    BorderPane arenaframe;
    Scene scene;
    MenuBar menubar;
    GameLibraryView library;
    Menu userAccount = new Menu("Account");

    public ArenaFrame() {
        stage = new Stage();
        arenaframe = new BorderPane();
        scene = new Scene(arenaframe, 800, 600);
        menubar = new MenuBar();
        library  = new GameLibraryView(arenaframe);
        AdvertisementView adView = new AdvertisementView(arenaframe);
        adView.setAdvertisement("image/VisitorAd.gif"); // sätter reklambilden
    }

    public void displayArena() {

        arenaStyle();
        setupMenu(); //anropar inställningarna för menyn
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }

    private void arenaStyle() {

        Background background = new Background(new BackgroundImage(
                new Image("image/greenBG.jpg"),
                BackgroundRepeat.SPACE,
                BackgroundRepeat.SPACE,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT));

        arenaframe.setBackground(background);
    }

    private void setupMenu() {
        arenaframe.setTop(menubar);

        Menu gamesMenu = new Menu("Games");
        MenuItem shop = new MenuItem("Shop");
        MenuItem games = new MenuItem("Games");
        gamesMenu.getItems().addAll(shop, games);
        games.setOnAction(event -> library.showGameLibrary());
        shop.setOnAction(event -> System.out.println("SHOP"));

        menubar.getMenus().addAll(gamesMenu, userAccount);
    }
}
