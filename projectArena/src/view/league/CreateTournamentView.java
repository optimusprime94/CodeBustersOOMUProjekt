/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.league;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.league.GetTournaments;
import view.administration.InstallGameView;

/**
 *
 * @author S153298
 */
public class CreateTournamentView {
    
    private BorderPane arenaFrame;
    public CreateTournamentView(BorderPane arenaFrame)
    {
        this.arenaFrame = arenaFrame;
    }
    public void show()
    {
        Button btCreateTournament = new Button("Create tournament");
        TextField tournamentName = new TextField();
        TextField numberOfPlayers = new TextField();
        Label labelNumberOfPlayers = new Label("Number of players");
        Label labelTournamentName = new Label("Tournament name");
        ComboBox<String> box = new ComboBox<>();
        GetTournaments gT = new GetTournaments();
        ObservableList<String> items = FXCollections.observableArrayList(gT.getTournaments());
        box.getItems().addAll(items);
        
        
        VBox vBox = new VBox();
        arenaFrame.setCenter(vBox);
        vBox.getChildren().addAll(btCreateTournament, labelTournamentName, tournamentName, labelNumberOfPlayers, numberOfPlayers, box);
        btCreateTournament.setOnAction(e->{
            System.out.println("You created a " + box.getValue() + " tournament with " + numberOfPlayers.getText() + " players, named " + tournamentName.getText());
            arenaFrame.getChildren().remove(vBox);
        });
        
    }
    
}
