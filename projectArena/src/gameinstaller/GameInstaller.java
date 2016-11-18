/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameinstaller;

import exceptions.GameIDNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Nick
 */
public class GameInstaller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        try {
          
            Library library = new Library();
            try
            {
                library.initializeLibrary();
            }
            catch(SQLException ex)
            {
                System.out.printf(ex.getMessage());
            }
            Game game = new Game("Mario kart4", "1");
            try
            {
            library.installNewGame(game);
            }
             catch(SQLException ex)
            {
                System.out.printf(ex.getMessage());
            }
            library.deleteGame(game);
//          game = new Game("Generic game 4", library);
//            game = library.getGame(8);
//            library.deleteGame(game);
            
//        } catch (GameIDNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//        } catch (GameIDNotFoundException ex) {
//            Logger.getLogger(GameInstaller.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
