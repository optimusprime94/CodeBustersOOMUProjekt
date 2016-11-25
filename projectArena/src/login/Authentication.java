/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;


/**
 *
 * @author S153298
 */
public class Authentication{

    public static void authenticateAccount(String username, String password){
        if(compare(username, password))
            System.out.println("Yay");
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "On the field of battle, there are no second chances");
            alert.setHeaderText("Invalid Username/Password");
            alert.showAndWait();
        }
    }
    
    private static boolean compare(String username, String password){
        if(UserDatabase.getUser(username)){
            if(password.equals(UserDatabase.getPassword(username))){
                return true;
            }
        }
        return false;    
    }
}
