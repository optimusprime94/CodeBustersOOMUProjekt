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
public class DefineAdvertisementSchemeView {
    
    private BorderPane arenaFrame;
    public DefineAdvertisementSchemeView(BorderPane arenaFrame)
    {
       this.arenaFrame = arenaFrame; 

        Button btn = new Button();
        btn.setText("Change the display time");
       
        Label id = new Label("Id:");
        Label time = new Label("Time:");
        TextField idField = new TextField();
        TextField timeField = new TextField();

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(id, idField, time, timeField,  btn);
        arenaFrame.setCenter(vBox);
        
        btn.setOnAction(e->
        {
            String idString = idField.getText();
            String timeString = timeField.getText();
            HandleAdvertisement.changeAdvertisementTime(idString, timeString);
            arenaFrame.getChildren().remove(vBox);
        });
    } 
}