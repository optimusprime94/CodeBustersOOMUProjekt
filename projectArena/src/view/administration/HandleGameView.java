/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.administration;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author S153977
 */
public class HandleGameView {

    private BorderPane arenaFrame;

    public HandleGameView(BorderPane arenaFrame) {
        this.arenaFrame = arenaFrame;
    }

    /**
     * show, shows these components for the User
     */
    public void show() {
        Button installGame = new Button("Install New Game");
        Button deleteGame = new Button("Delete Game");
        /* min bredd för lite enformighet. */
        installGame.setMaxWidth(Double.MAX_VALUE);
        deleteGame.setMaxWidth(Double.MAX_VALUE);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(10);
        arenaFrame.setCenter(vBox);
        vBox.getChildren().addAll(installGame, deleteGame);
        installGame.setOnAction(e -> {
            InstallGameView installView = new InstallGameView(arenaFrame);
            installView.addGame();
            arenaFrame.getChildren().remove(vBox);
        });

    }

}
