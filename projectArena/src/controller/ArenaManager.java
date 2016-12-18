/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.stage.Stage;
import view.ArenaView;
import view.StartView;

/**
 *
 * @author Elvir
 */
public class ArenaManager {

    private ArenaView start;
    private Stage stage;

    public ArenaManager(Stage stage) {
        this.stage = stage;
        this.stage.close();
        start = new StartView(stage);

    }

    public void run() {
        start.displayArena();
    }

}
