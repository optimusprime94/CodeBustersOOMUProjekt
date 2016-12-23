/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.advertisement;

/**
 *
 * @author S153298
 */
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.advertisement.Advertisement;

/**
 *
 * @author S153977
 */
public class HandleAdvertismentView {
    private BorderPane arenaFrame;
    public HandleAdvertismentView(BorderPane arenaFrame)
    {
       this.arenaFrame = arenaFrame; 

        Button btn = new Button();
        btn.setText("Create new ad");
       
        Label name = new Label("Name:");        //Currently no usefulness
        Label time = new Label("Time:");
        Label urlPath = new Label("URL path:");
        Label imagePath = new Label("Image path:");
        TextField nameField = new TextField();      //Currently no usefulness
        TextField timeField = new TextField();
        TextField urlPathField = new TextField();
        TextField imagePathField = new TextField();
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(name, nameField, time, timeField, urlPath, urlPathField, imagePath, imagePathField, btn);
        arenaFrame.setCenter(vBox);
        
        btn.setOnAction(e->
        {
            String urlPathString = urlPathField.getText();
            String imagePathString = imagePathField.getText();
            String timeString = timeField.getText();
            Advertisement newAdvertisement = new Advertisement(imagePathString, timeString, urlPathString);
            
            arenaFrame.getChildren().remove(vBox);
        });
    }    
}