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
/**
 * Takes a username and password, if they are correct it returns true, or else
 * it will display a message stating it was incorrect and return false.
 * @param username
 * @param password
 * @return 
 */
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
/**
 * This function takes a username and a password, it then checks if the username 
 * is in the database, if so it then checks if the entered password matches that
 * of the username's password in the database. If so, return true, else false.
 * @param username
 * @param password
 * @return 
 */    
    private static boolean compare(String username, String password){
        if(UserDatabase.getUser(username)){
            if(password.equals(UserDatabase.getPassword(username))){
                return true;
            }
        }
        return false;    
    }
}
