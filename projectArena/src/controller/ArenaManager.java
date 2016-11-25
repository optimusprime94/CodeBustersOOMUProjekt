/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.stage.Stage;
import login.LoginView;
import view.ArenaView;
import view.userviews.OperatorView;
import view.userviews.PlayerView;

/**
 *
 * @author Elvir
 */
public class ArenaManager {

    ArenaView frame;

    public ArenaManager(Stage stage) {
        LoginView login = new LoginView(stage);
        //frame = new PlayerView("username");

    }

    public void run() {
       // frame.displayArena();
    }

}
