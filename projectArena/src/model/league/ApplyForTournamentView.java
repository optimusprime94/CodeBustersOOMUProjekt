/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.league;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;



/**
 *
 * @author S153977
 */
public class ApplyForTournamentView
{
    private BorderPane arenaFrame;
    public ApplyForTournamentView(BorderPane arenaFrame)
    {
        this.arenaFrame = arenaFrame;
    }
    public void show()
    {
        DatabaseManager dbtManager = new DatabaseManager();
        
        ComboBox<String> tournaments = new ComboBox<>();
        tournaments.getItems().addAll(dbtManager.getActiveTournamnets());
        TextField tf = new TextField();
        Label label = new Label("Enter the id of the tournament");
        VBox vbox = new VBox();
        Button button = new Button("Apply");
        vbox.getChildren().addAll(label, tf, button, tournaments);
        arenaFrame.setCenter(tournaments);
        arenaFrame.setLeft(vbox);
        
        
             
    }  
}
