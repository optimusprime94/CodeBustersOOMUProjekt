/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.general;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.general.login.Authentication;
import view.userviews.PlayerView;


/**
 *
 * @author S153298
 */
import view.CreateAccountView;
import view.StartView;


public class LoginView {

    private GridPane gridPane;
    private TextField usernameField = new TextField();
//    private TextField passwordfield = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button btLogin = new Button("Enter the Arena");
    private Label btSignUp = new Label("Sign up");
    private String username;

    public LoginView(Stage primaryStage) {

        this.gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        btSignUp.setOnMouseClicked(e ->{ 
               CreateAccountView creatAccount = new CreateAccountView();
               creatAccount.show();
               
                       });
        gridPane.add(btSignUp, 3, 0);
        gridPane.add(new Label("Username"), 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(new Label("Password:"), 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(btLogin, 1, 5);


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

    }
/**
 * This function activates upon clicking the login button, and takes the String 
 * stored in the username/password fields and returns true if they are valid.
 * @return 
 */
    private boolean Authenticated() {
        /* Get values from text fields, andt authenticate */
        this.username = usernameField.getText();
        String password = passwordField.getText();
        return Authentication.authenticateAccount(username, password);
    }
/**
 * This function switches the window from the login page to the ARENA main menu
 * @param primaryStage 
 */
    private void login(Stage primaryStage) {
        PlayerView view = new PlayerView(username, primaryStage);
        view.displayArena();
    }
    
    public Node getLoginView(){
        return gridPane;
    }

}
