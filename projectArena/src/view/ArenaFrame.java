/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
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

    public ArenaFrame() {
        stage = new Stage();
        arenaframe = new BorderPane();
        scene = new Scene(arenaframe, 1000, 1000);
        menubar = new MenuBar();
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
    
    private void setupMenu(){
        arenaframe.setTop(menubar);
        Menu gameLibrary = new Menu("Game Library");
        Menu userAccount = new Menu("Account");
        menubar.getMenus().addAll(gameLibrary, userAccount);
    }
}
