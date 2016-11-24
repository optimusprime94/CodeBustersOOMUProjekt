/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author S153977
 */
public class HandleGameView {
    private BorderPane arenaFrame;
    public HandleGameView(BorderPane arenaFrame)
    {
        this.arenaFrame = arenaFrame;
    }
    public void show()
    {
        Button installGame = new Button("Install New Game");
        Button deleteGame = new Button("Delete Game");
        VBox vBox = new VBox();
        arenaFrame.setCenter(vBox);
        vBox.getChildren().addAll(installGame, deleteGame);
        installGame.setOnAction(e->{
            InstallGameView installView = new InstallGameView(arenaFrame);
            installView.addGame();
            arenaFrame.getChildren().remove(vBox);
        });
        
    }
    
}
