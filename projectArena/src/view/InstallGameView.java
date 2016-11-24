/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author S153977
 */
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import gameinstaller.HandleGame;
import gameinstaller.Game;

/**
 *
 * @author S153977
 */
public class InstallGameView 
{ 
    private Stage primaryStage;
    private BorderPane arenaFrame;
    public InstallGameView(BorderPane arenaFrame)
    {
       this.arenaFrame = arenaFrame; 
    }

    InstallGameView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addGame()
    {
        Button btn = new Button();
        btn.setText("add game");
       
        Label name = new Label("Name:");
        Label visibility = new Label("Visibility (1/0):");
        Label gamePath = new Label("Game path:");
        Label imagePath = new Label("Image path:");
        TextField nameField = new TextField();
        TextField visibilityField = new TextField();
        TextField gamePathField = new TextField();
        TextField imagePathField = new TextField();
        VBox vBox = new VBox();
        vBox.getChildren().addAll(name, nameField, visibility, visibilityField, gamePath, gamePathField, imagePath, imagePathField, btn);
        arenaFrame.setCenter(vBox);
        
        btn.setOnAction(e->
        {
            int visibilityInt = 2;
            if (visibilityField.getText().matches("1"))
            {
                visibilityInt = 1;
            }
            else if (visibilityField.getText() == "0")
            {
                visibilityInt = 0;
            }
            if (nameField.getText().length() == 0 | gamePathField.getText().length() == 0 |imagePathField.getText().length() == 0| visibilityField.getText().length() == 0 | (visibilityInt != 0 & visibilityInt != 1))
            {
                String text = "";
                if (visibilityInt != 0 & visibilityInt != 1)
                {
                    text = ("visibility must be '1' or '0'");
                }
                else
                {
                    text = ("None of the fields can be empty");
                }
                Text error = new Text(50, 50, text);
                Button okButton = new Button("OK");
                BorderPane borderPane = new BorderPane();
                borderPane.setCenter(error);
                borderPane.setBottom(okButton);
                Scene newScene = new Scene(borderPane, 250, 250);
                Stage primary = new Stage();
                primary.setScene(newScene);
                primary.show();
                okButton.setOnMouseClicked(event-> {
                primary.close();
                });                      
            }
            else
            {
                String gameName = nameField.getText();
                String gamePathString = gamePathField.getText();
                String imagePathString = imagePathField.getText();
                String visibilityString = visibilityField.getText();
                Game game = new Game(gameName, visibilityString, gamePathString, imagePathString);
                HandleGame gameHandler = new HandleGame();
                gameHandler.installNewGame(game);
                arenaFrame.getChildren().remove(vBox);
            }           
        });
    }    
}
