/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userviews;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.general.login.UserDatabase;

/**
 *
 * @author S143522
 */
class HandleUsersView {

    private BorderPane mainframe;
    private GridPane grid;
    private Button create, remove, update;
    private TextField tfAccountName, tfPassword, tfType;

    public HandleUsersView(BorderPane mainframe) {
        this.mainframe = mainframe;
        grid = new GridPane();
        gridLayout();
        buttonConfigurations();
    }

    private void gridLayout() {
        Label lblaccountName = new Label("Account Name: ");
        Label lblPassword = new Label("Password: ");
        Label lblType = new Label("UserType (0 = no change): ");
        tfAccountName = new TextField();
        tfPassword = new TextField();
        tfType = new TextField();
        create = new Button("Create");
        remove = new Button("Remove");
        update = new Button("Update");

        grid.addRow(1, lblaccountName, tfAccountName);
        grid.addRow(2, lblPassword, tfPassword);
        grid.addRow(3, lblType, tfType);

        grid.addRow(5, remove);
        grid.addRow(6, update);
        grid.paddingProperty().set(new Insets(20));
        grid.setVgap(20);
        // grid.setHgap(10);

        mainframe.setCenter(grid);
    }

    private void buttonConfigurations() {

        update.setOnAction(e -> {

            int type = Integer.parseInt(tfType.getText());
            String password = tfPassword.getText();
            String name = tfAccountName.getText();
            System.out.print(name + password + type);
            UserDatabase.updateUser(name, password, type);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("User account is now UPDATED!");
            alert.showAndWait();
        });

        remove.setOnAction(e -> {
            String name = tfAccountName.getText();
            UserDatabase.deleteUser(name);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("User account is now DELETED!");
            alert.showAndWait();
        });

    }
}
