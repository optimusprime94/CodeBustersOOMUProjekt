/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.general.login.UserDatabase;

/**
 *
 * @author S153977
 */
public class CreateAccountView {

    private BorderPane borderPane;
    private Stage stage;
    private Scene scene;

    public CreateAccountView() {
        this.borderPane = new BorderPane();
        this.scene = new Scene(borderPane, 250, 200);
        this.stage = new Stage();
        stage.setScene(scene);
    }

    public void show() {
        Label nameLabel = new Label("User name");
        Label passwordLabel = new Label("Password");
        TextField nameField = new TextField();
        TextField passwordField = new TextField();

        Button register = new Button("Register");
        VBox vBox = new VBox();
        borderPane.setBackground(ArenaView.arenaTheme());
        vBox.getChildren().addAll(nameLabel, nameField, passwordLabel, passwordField, register);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20));
        borderPane.setCenter(vBox);
        
        /* Kontroll på uppgifterna som användaren matar in. */
        register.setOnAction(e -> {
            String name = nameField.getText();
            String password = passwordField.getText();

            if (UserDatabase.getUser(name)) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Name is already in use");
                alert.setHeaderText("Invalid Username/Password");
                alert.showAndWait();
            }

            if (name.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Name must be longer then 0 characters");
                alert.setHeaderText("Invalid Username/Password");
                alert.showAndWait();
            } else if (password.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "password must be longer then 0 characters");
                alert.setHeaderText("Invalid Username/Password");
                alert.showAndWait();
            } else {
                UserDatabase.newUser(name, password, 1);
                stage.close();
            }

        });
        stage.show();
    }
}
