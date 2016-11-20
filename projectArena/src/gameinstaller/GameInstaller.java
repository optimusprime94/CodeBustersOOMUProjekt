/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameinstaller;

import exceptions.GameIDNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;



/**
 *
 * @author Nick
 */
public class GameInstaller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Library library = new Library();
        try{
            library.initializeLibrary();
        }
            
        catch(SQLException ex){
            System.out.printf(ex.getMessage());
        }
        Game game = new Game("Marcus plockar 3", "1");
        try{
            library.installNewGame(game);
        }
            
        catch(SQLException ex){
            System.out.printf(ex.getMessage());
        }
            
        try{
            Game gameToDelete = library.getGame(6);
            library.deleteGame(gameToDelete);
        }
            
        catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
    }
}
