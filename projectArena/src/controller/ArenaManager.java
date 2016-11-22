/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.ArenaView;
import view.userviews.OperatorView;
import view.userviews.PlayerView;

/**
 *
 * @author Elvir
 */
public class ArenaManager {

    ArenaView frame;

    public ArenaManager() {
        frame = new PlayerView("username");

    }

    public void run() {
        frame.displayArena();
    }

}
