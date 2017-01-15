/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ArenaManager;
import view.advertisement.AdvertisementView;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Elvir
 */
public abstract class ArenaView {

    protected Stage stage;
    private Scene scene;
    private HBox topBox;
    Menu accountMenu;
    Menu homeMenu = new Menu("Home");
    Menu arenaMenu = new Menu("Arena");

    /* attributer som subklasserna skall kunna komma åt och/ eller ändra. */
    protected String username = "Welcome to Arena!";
    protected BorderPane arenaframe;
    protected MenuBar menubar;
    protected int minWidth = 800, minHeight = 600;
    /* MenuItems som skall följa med alla som ärver från arenaview */
    protected MenuItem logoutItem = new MenuItem("sign out");
    protected MenuItem homeItem = new MenuItem("Go to home");
    protected MenuItem aboutUsItem = new MenuItem("About us");
    protected MenuItem aboutArenaItem = new MenuItem("About Arena");

    AdvertisementView adView;                                                   //Ändrad

    public ArenaView(Stage stage) {
        /* skapar stage och sätter stagens minsta möjliga storlek. */
        this.stage = stage;
        this.stage.setMinHeight(minHeight);
        this.stage.setMinWidth(minWidth);

        arenaframe = new BorderPane();
        scene = new Scene(arenaframe, minWidth, minHeight);
        menubar = new MenuBar();

        adView = new AdvertisementView(arenaframe);                             //Ändrad
        adView.setAdvertisement("view/image/ad_arena.png"); // sätter reklambilden

        /* används så att användarens namn visas */
        topBox = new HBox(menubar);

        actions();
    }

    public void displayArena() {

        scene.getStylesheets().add("view/arenastylesheet.css");
        arenaframe.setBackground(arenaTheme());
        initMenu(); //anropar inställningarna för menyn
        stage.setTitle("Arena");
        stage.setScene(scene);
        stage.show();
    }

    public static Background arenaTheme() {

        Background background = new Background(new BackgroundImage(
                new Image("view/image/lightTheme3.jpg"),
                BackgroundRepeat.SPACE,
                BackgroundRepeat.SPACE,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)));

        return background;

    }

    private void initMenu() {
        arenaframe.setTop(menubar);

        menubar.setStyle(
                "-fx-font-size: 20 pt;" // menubar, text storlek.
                + "-fx-font-family: Segoe UI Light;"
                + "-fx-padding: 10 50 10 50;" // top, right, bottom, left
                + "-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, Black, 50, 0, 0, 0);");

        /* skapar och sätter in items i homeMenu. */
        homeMenu.getItems().addAll(homeItem);
        arenaMenu.getItems().addAll(aboutUsItem, aboutArenaItem);
        menubar.getMenus().addAll(homeMenu, arenaMenu);
    }

    protected void LogoutMenu() {
        accountMenu = new Menu(username);
        accountMenu.getItems().add(logoutItem);
        menubar.getMenus().add(accountMenu);
        logoutItem.setOnAction(e -> {
            ArenaManager am = new ArenaManager(stage);
            am.run();
        });

    }

    private void actions() {
        aboutArenaItem.setOnAction(e -> new AboutArenaView(arenaframe));
        homeItem.setOnAction(event -> {

            ImageView iv = new ImageView(new Image("view/image/romanbattle.png"));
            Pane pane = new Pane(iv);
            iv.fitWidthProperty().bindBidirectional(pane.layoutXProperty());
            iv.fitHeightProperty().bindBidirectional(pane.layoutYProperty());
            arenaframe.setCenter(iv);

        });
    }
}
