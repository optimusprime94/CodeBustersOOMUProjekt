/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.advertisement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import model.administration.Game;
/**
 *
 * @author JohnBosco
 */
public class HandleAccountBalance {
    public static void addFund(int id, int money)
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String SQLMessage = "update advertiser set Cash = Cash + "+ money+" where ID = "+id+";";
            statement.executeUpdate(SQLMessage);
            connection.close();
        }
        catch (SQLException ex)
        {
            System.out.print(ex.getMessage());
        } 
    }

    public static int getBalance(int id) 
    {
        int balance = 0;
        try 
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String SQLMessage = "Select Cash from advertiser where id = " + id + "";
            ResultSet resultSet = statement.executeQuery(SQLMessage);
            while (resultSet.next()) 
            {
                balance = Integer.parseInt(resultSet.getString(1));
            }
            connection.close();
        } 
        catch (SQLException ex) 
        {
            System.out.print(ex.getMessage());
        }
        return(balance);
    }
}
