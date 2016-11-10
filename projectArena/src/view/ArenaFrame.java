/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
    
    public void displayArena(){
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }
    
}
