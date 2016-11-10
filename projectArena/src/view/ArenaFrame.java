/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.Scene;
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

    public ArenaFrame() {
        stage = new Stage();
        arenaframe = new BorderPane();
        scene = new Scene(arenaframe, 1000, 1000);

    }

    public void displayArena() {
        
        arenaStyle();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }

    private void arenaStyle() {

        Background background = new Background(new BackgroundImage(
                new Image("image/bakgrund.jpg"),
                BackgroundRepeat.SPACE,
                BackgroundRepeat.SPACE,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT));

        arenaframe.setBackground(background);
    }
}
