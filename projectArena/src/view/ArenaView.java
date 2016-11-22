/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Elvir
 */
public abstract class ArenaView {

    private Stage stage;
    private Scene scene;

    private VBox rightPanel;

    /* attributer som subklasserna skall kunna komma åt och/ eller ändra. */
    protected BorderPane arenaframe;
    protected MenuBar menubar;
    protected String username;
    protected int minWidth = 800, minHeight = 600;
    Menu userAccountMenu = new Menu("Account");
    Menu homeMenu = new Menu("Home");
    Menu arenaMenu = new Menu("Arena");

    public ArenaView() {
        /* skapar stage och sätter stagens minsta möjliga storlek. */
        this.stage = new Stage();
        this.stage.setMinHeight(minHeight);
        this.stage.setMinWidth(minWidth);

        arenaframe = new BorderPane();
        scene = new Scene(arenaframe, minWidth, minHeight);
        menubar = new MenuBar();


        AdvertisementView adView = new AdvertisementView(arenaframe);
        adView.setAdvertisement("image/ad_arena.png"); // sätter reklambilden

        /* används så att användarens namn visas */
        rightPanel = new VBox();
        this.username = username;
    }

    public void displayArena() {

        arenaStyle();
        initMenu(); //anropar inställningarna för menyn
        displayRightPanel();
        stage.setTitle("Arena");
        stage.setScene(scene);
        stage.show();
    }

    private void arenaStyle() {

        Background background = new Background(new BackgroundImage(
                new Image("image/lightTheme3.jpg"),
                BackgroundRepeat.SPACE,
                BackgroundRepeat.SPACE,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT));
        arenaframe.setBackground(background);

    }

    private void initMenu() {
        arenaframe.setTop(menubar);

        menubar.setStyle(
                "-fx-font-size: 20 pt;" // menubar, text storlek.
                + "-fx-font-family: Segoe UI Light;"
                + "-fx-padding: 10 50 10 50;" // top, right, bottom, left
                + "-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, Black, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");




        /* skapar och sätter in items i homeMenu. */
        MenuItem homeItem = new MenuItem("Go to home");
        homeMenu.getItems().addAll(homeItem);

        MenuItem aboutUsItem = new MenuItem("About us");

        MenuItem aboutArenaItem = new MenuItem("About Arena");
        arenaMenu.getItems().addAll(aboutUsItem, aboutArenaItem);
        aboutArenaItem.setOnAction(e -> new AboutArenaView(arenaframe));


        homeItem.setOnAction(event -> System.out.println("Welcome home!"));

        menubar.getMenus().addAll(homeMenu, userAccountMenu, arenaMenu);
    }

    public void displayRightPanel() {
        Label user = new Label(username);
        user.setOnMouseEntered(e -> user.setEffect(new DropShadow(15, Color.DARKGREEN)));
        user.setOnMouseExited(e -> user.setEffect(new DropShadow(15, Color.TRANSPARENT)));
        user.setStyle(
                "-fx-font-size: 20 pt;" // text storlek.

                + "-fx-text-fill: dodgerblue;"
                + "-fx-font-family: Segoe UI Light;"
                + "-fx-padding: 10 50 10 50;"); // top, right, bottom, left);
        rightPanel.getChildren().add(user);
        // arenaframe.setRight(rightPanel);

    }
}
