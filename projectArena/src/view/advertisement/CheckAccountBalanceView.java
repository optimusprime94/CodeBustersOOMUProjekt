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


/**
 *
 * @author S153298
 */
public class CheckAccountBalanceView {
    private BorderPane arenaFrame;
    public CheckAccountBalanceView(BorderPane arenaFrame)
    {
       this.arenaFrame = arenaFrame; 

        Button btnAdd = new Button();
        
        btnAdd.setText("Add more funds");
        int currentCash = 50;
        Label currentCashLabel = new Label(currentCash + "SEK");
        Label amountLabel = new Label("Extra money");
       
        TextField amountField = new TextField();
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(currentCashLabel, amountLabel, amountField, btnAdd);
        arenaFrame.setCenter(vBox);
        
        btnAdd.setOnAction(e->
        {
            String amountString = amountField.getText();
            int total = Integer.parseInt(amountString) + currentCash;
            System.out.println(total);
            arenaFrame.getChildren().remove(vBox);
        });
        
    }    
}