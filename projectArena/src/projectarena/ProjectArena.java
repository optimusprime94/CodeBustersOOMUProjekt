/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectarena;

import controller.ArenaManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Elvir
 */
public class ProjectArena extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        ArenaManager arena = new ArenaManager(stage);
        
        arena.run();

    }

}
