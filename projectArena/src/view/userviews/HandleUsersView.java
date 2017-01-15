/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.userviews;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.general.login.UserDatabase;

/**
 *
 * @author S143522
 */
class HandleUsersView {

    /* Attributes */
    private BorderPane mainframe;
    private GridPane grid;
    private Button remove, update;
    private TextField tfAccountName, tfPassword, tfType;
    private ListView<String> list;
    private HBox box;

    /* Constructor */
    public HandleUsersView(BorderPane mainframe) {
        this.mainframe = mainframe;
        grid = new GridPane();
        /* gets an list with users from the database. */
        ObservableList<String> users = UserDatabase.showUser();
        list = new ListView<>(users);
        box = new HBox(list, grid);
        handleUserLayout();
        buttonConfigurations();
        mainframe.setCenter(box);
    }

    /**
     * This method creates the layout for handle users, and displays all the
     * necessary information for handling a user.
     */
    private void handleUserLayout() {
        Label lblaccountName = new Label("Account Name: ");
        Label lblPassword = new Label("Password: ");
        Label lblType = new Label("UserType (0 = no change): ");
        tfAccountName = new TextField();
        tfPassword = new TextField();
        tfType = new TextField();
        remove = new Button("Remove");
        update = new Button("Update");

        grid.addRow(1, lblaccountName, tfAccountName);
        grid.addRow(2, lblPassword, tfPassword);
        grid.addRow(3, lblType, tfType);
        //grid.gridLinesVisibleProperty().setValue(Boolean.TRUE);
        grid.addRow(5, remove);
        grid.addRow(6, update);
        grid.paddingProperty().set(new Insets(20));
        grid.setVgap(20);

        list.setMinWidth(300);
        list.layoutYProperty().bindBidirectional(grid.layoutYProperty());
        list.layoutXProperty().bindBidirectional(box.layoutXProperty());
    }

    /**
     * Adds functionality to the buttons, update and remove. Update which
     * updates an existing user, and remove, which deletes an existing user.
     */
    private void buttonConfigurations() {

        update.setOnAction(e -> {
            String name = tfAccountName.getText();
            if (!(UserDatabase.getUser(name))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("User not found");
                alert.showAndWait();
            } else {
                int type = Integer.parseInt(tfType.getText());
                String password = tfPassword.getText();
                System.out.print(name + password + type);
                UserDatabase.updateUser(name, password, type);
                /* Uppdaterar listan när en ändring har gjorts*/
                ObservableList<String> users = UserDatabase.showUser();
                list.getItems().clear();
                list.getItems().addAll(users);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("User account is now UPDATED!");
                alert.showAndWait();
            }
        });

        remove.setOnAction(e -> {
            String name = tfAccountName.getText();
            if (!(UserDatabase.getUser(name))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("User not found");
                alert.showAndWait();
            } else {
                UserDatabase.deleteUser(name);
                /* Uppdaterar listan när en ändring har gjorts*/
                ObservableList<String> users = UserDatabase.showUser();
                list.getItems().clear();
                list.getItems().addAll(users);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("User account is now DELETED!");
                alert.showAndWait();
            }
        });

    }
}
