/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.ArenaFrame;

/**
 *
 * @author Elvir
 */
public class ArenaManager {

    ArenaFrame frame;

    public ArenaManager() {
        frame = new ArenaFrame("username");

    }

    public void run() {
        frame.displayArena();
    }

}
