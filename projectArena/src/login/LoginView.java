/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.userviews.PlayerView;

/**
 *
 * @author S153298
 */
public class LoginView {

    private TextField usernameField = new TextField();
//    private TextField passwordfield = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button btLogin = new Button("Enter the Arena");
    private Label btSignUp = new Label("Sign up");
    private String username;

    public LoginView(Stage primaryStage) {

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        btSignUp.setOnMouseClicked(e -> System.out.println("You're signed up"));
        gridPane.add(btSignUp, 3, 0);
        gridPane.add(new Label("Username"), 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(new Label("Password:"), 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(btLogin, 1, 5);
//                                                                                                                                                                                                  gridPane.add(new Label("Welcome, brave warriors and foolish men, to a place where might rules supreme, a place where \n a man is judged not by his wealth, but by the man that lies dead at his feet.\n Prepare to prove yourself, prepare to fall, prepare to be hailed as a hero, prepare to be forgotten.\n But most importantly, prepare to:"), 1, 4);
        Background background = new Background(new BackgroundImage(
                new Image("image/lightTheme3.jpg"),
                BackgroundRepeat.SPACE,
                BackgroundRepeat.SPACE,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT));
        gridPane.setBackground(background);

        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        usernameField.setAlignment(Pos.BOTTOM_LEFT);
        passwordField.setAlignment(Pos.BOTTOM_LEFT);

        GridPane.setHalignment(btLogin, HPos.RIGHT);

        // Process events
        btLogin.setOnAction(e -> {

            if (Authenticated()) {
                System.out.print(username);
                login(primaryStage);
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 700, 450);
        primaryStage.setTitle("Login"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private boolean Authenticated() {
        // Get values from text fields
        this.username = usernameField.getText();
        String password = passwordField.getText();
        return Authentication.authenticateAccount(username, password);
    }

    private void login(Stage primaryStage) {
        PlayerView view = new PlayerView(username, primaryStage);
        view.displayArena();
    }

}
