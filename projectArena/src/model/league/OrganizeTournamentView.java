/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.league;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.administration.Game;
import model.advertisement.Advertisement;
import view.administration.InstallGameView;

/**
 *
 * @author S153298
 */
public class OrganizeTournamentView {
    
    private BorderPane arenaFrame;
    public OrganizeTournamentView(BorderPane arenaFrame)
    {
        this.arenaFrame = arenaFrame;
    }
    public void show()
    {
        Button btCreateTournament = new Button("Create tournament");
        TextField tournamentName = new TextField();
        TextField numberOfPlayers = new TextField();
        TextField advertisment = new TextField();
        Label labelNumberOfPlayers = new Label("Number of players");
        Label labelTournamentName = new Label("Tournament name");
        Label labelAdverts = new Label("Select Advertisment id (1-4)");
        ComboBox<String> boxTournaments = new ComboBox<>();
        ComboBox<String> boxGames = new ComboBox<>();
        boxGames.setPromptText("Select Game                ");
        boxTournaments.setPromptText(("Select tournament"));
        DatabaseManager dbtManager = new DatabaseManager();
        ObservableList<String> tournaments = FXCollections.observableArrayList(dbtManager.getTournaments());
        ObservableList<String> games = FXCollections.observableArrayList(dbtManager.getGames()); 
        ArrayList<Advertisement> adverts = dbtManager.getAdverts();
        boxGames.getItems().addAll(games);
        boxTournaments.getItems().addAll(tournaments);
        VBox vBox = new VBox();
        arenaFrame.setCenter(vBox);
        vBox.getChildren().addAll(labelTournamentName, tournamentName, labelAdverts, advertisment, labelNumberOfPlayers, numberOfPlayers, boxGames, boxTournaments, btCreateTournament);
        vBox.setPadding(new Insets(20));
        btCreateTournament.setOnAction(e->{
            String tourName = tournamentName.getText();
            int nrOfPlayers = Integer.parseInt(numberOfPlayers.getText());
            String game = boxGames.getValue();
            String tourStyle = boxTournaments.getValue();
            int advertID = Integer.parseInt(advertisment.getText());
            if (tourStyle.matches("Elemination tournament"))
            {
                if (game.matches("Othello"));
                {
                    Game othello = new Game("othello", "1", "src/gamelib", "image/icons/othello.png");
                    Tournament newTournament = new EleminationTournament(nrOfPlayers, othello, tournamentName.getText());
                    newTournament.addAdvert(adverts.get(advertID-1)); 
                    dbtManager.saveTournament(newTournament);
                }
            }
        }); 
    }  
}
