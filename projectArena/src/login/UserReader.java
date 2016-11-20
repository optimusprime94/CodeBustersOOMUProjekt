/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author S153298
 */
public class UserReader {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Nick
 */

    private Scanner in;
    private File inputFile;
    
    public UserReader(String input) throws FileNotFoundException{
        inputFile = new File(input);
        try {
            in = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }
    }
    

    protected String getInput(){
        if (in.hasNextLine()){
            return(in.nextLine());
        }
        else {
            System.out.println("End of file reached");
            return null;
        }
    }
    
    
    public int authenticate(String username, String password){
        in.close();
        try {
            in = new Scanner(inputFile);
        
        int accountId;
        String tempUsername;
        String tempPassword;
        String userType;
        while(in.hasNext()){
            accountId = Integer.valueOf(getInput());
            tempUsername = getInput();
            tempPassword = getInput();
            userType = getInput();
            if (tempUsername.equals(username) && tempPassword.equals(password))
                return accountId;
            }
        }
         catch (FileNotFoundException ex) {
            Logger.getLogger(UserReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}