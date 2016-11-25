/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.scene.control.Alert;




/**
 *
 * @author S153298
 */
public class Authentication{

    public static boolean authenticateAccount(String username, String password){
        if(compare(username, password))
            return true;
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "On the field of battle, there are no second chances");
            alert.setHeaderText("Invalid Username/Password");
            alert.showAndWait();
            return false;
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
