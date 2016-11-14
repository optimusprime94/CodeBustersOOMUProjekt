/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author S143522
 */
class GameLibraryView {

    private BorderPane arenaframe;
    private String[] gameTitles = {"Assassin's Creed 2", "Othello", "Nicks fantasier"};

    GameLibraryView(BorderPane arenaframe) {
        this.arenaframe = arenaframe;
    }

    public void showGameLibrary() {
        
        ListView<String> gameList = new ListView<>(FXCollections.observableArrayList(gameTitles));
        gameList.setPrefSize(400, 400);
        gameList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        arenaframe.setCenter(gameList);
      
    }
}
