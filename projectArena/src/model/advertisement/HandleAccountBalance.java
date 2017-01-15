/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.advertisement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application; 
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene; 
/**
 *
 * @author JohnBosco
 */
public class HandleAccountBalance {
    public static void addFund(Advertisement newAd)
    {
        try{
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
        Statement statement = connection.createStatement();
       
        String filePath = newAd.getFilePath();
        String currentBalance = newAd.getBalance();
       
       // String SQLMessage =String SQLMessage = "Increse money where the ID is =" +id;
        //statement.executeUpdate(SQLMessage);
        connection.close();
        }
        catch (SQLException ex)
        {
            System.out.print(ex.getMessage());
        } 
    }
     }