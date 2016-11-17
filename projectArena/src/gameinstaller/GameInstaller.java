/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameinstaller;

import exceptions.GameIDNotFoundException;
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
            //        try {
            // TODO code application logic here
            Library library = new Library("GameDatabase.txt");
            library.initializeLibrary();
            Game game = new Game("Generic game 8", library);
            library.installNewGame(game);
//          game = new Game("Generic game 4", library);
//            game = library.getGame(8);
//            library.deleteGame(game);
            library.printLibrary();
//        } catch (GameIDNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//        } catch (GameIDNotFoundException ex) {
//            Logger.getLogger(GameInstaller.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
