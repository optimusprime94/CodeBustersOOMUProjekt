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
import model.advertisement.HandleAccountBalance;
import model.general.login.UserDatabase;


/**
 *
 * @author S153298
 */
public class CheckAccountBalanceView {
    private BorderPane arenaFrame;
    public CheckAccountBalanceView(BorderPane arenaFrame, String username)
    {
       this.arenaFrame = arenaFrame; 

        Button btnAdd = new Button();
        int id = Integer.parseInt(UserDatabase.getUserId(username));
        btnAdd.setText("Add more funds");
        int currentCash = HandleAccountBalance.getBalance(id);
        Label currentCashLabel = new Label("Current Balance: " + currentCash + " SEK");
        Label amountLabel = new Label("Add extra money");
       
        TextField amountField = new TextField();
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(currentCashLabel, amountLabel, amountField, btnAdd);
        arenaFrame.setCenter(vBox);
        
        btnAdd.setOnAction(e->
        {
            String amountString = amountField.getText();
            HandleAccountBalance.addFund(id, Integer.parseInt(amountString));
            arenaFrame.getChildren().remove(vBox);
        });
        
    }    
}