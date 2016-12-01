/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.administration.Game;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.ArenaView;

/**
 *
 * @author S143522 (Elvir Dzeko) Shut up we all contributed
 */
public class GameStarter {

    private Game game;
    
    public GameStarter(Game game) {
        this.game = game;
        startGame();
    }

    private void startGame() {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", game.getGameName() + ".jar");
            pb.directory(new File(game.getGamePath()));
            Process p = pb.start();

        } catch (IOException ex) {
            Logger.getLogger(ArenaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
