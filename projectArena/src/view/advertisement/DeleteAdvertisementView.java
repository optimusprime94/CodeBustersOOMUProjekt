/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.advertisement;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.advertisement.Advertisement;
import model.advertisement.HandleAdvertisement;

/**
 *
 * @author S153298
 */
public class DeleteAdvertisementView {
    private BorderPane arenaFrame;
    public DeleteAdvertisementView(BorderPane arenaFrame)
    {
       this.arenaFrame = arenaFrame; 

        Button btnDelete = new Button();
        
        btnDelete.setText("Delete ad");
        
       
        Label adIdLabel = new Label("ID:");
        TextField adIdField = new TextField();
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(adIdLabel, adIdField, btnDelete);
        arenaFrame.setCenter(vBox);
        
        btnDelete.setOnAction(e->
        {
            String adIdString = adIdField.getText();
            int adId = Integer.parseInt(adIdString);

            HandleAdvertisement.deleteAdvertisment(adId);
            arenaFrame.getChildren().remove(vBox);
        });
    }
}