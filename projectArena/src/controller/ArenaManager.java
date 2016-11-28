/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.stage.Stage;
import login.LoginView;
import view.ArenaView;
import view.StartView;
import view.userviews.OperatorView;
import view.userviews.PlayerView;

/**
 *
 * @author Elvir
 */
public class ArenaManager {

    ArenaView start;

    public ArenaManager(Stage stage) {
        start = new StartView(stage);

    }

    public void run() {
        start.displayArena();
    }

}
