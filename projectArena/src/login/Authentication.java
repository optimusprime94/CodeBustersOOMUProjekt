/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author S153298
 */
public class Authentication{

    public static void authenticateAccount(String username, String password){
        try {
            UserReader userReader = new UserReader("UserDatabase.txt");
        int x = userReader.authenticate(username, password);
        if(x != -1)
            System.out.println("Yay");
        else
            System.out.println("Nope");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
