/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.ArenaView;
import view.userviews.OperatorView;
import view.userviews.PlayerView;
import login.LoginView;
import view.StartView;

/**
 *
 * @author Elvir
 */
public class ArenaManager {

    StartView frame;

    public ArenaManager() {   
        frame = new LoginView();
    }

    public void run() {
        frame.displayStartView();
    }

}
