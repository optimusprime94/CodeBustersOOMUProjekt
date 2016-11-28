/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author optimusprime
 */
public class AboutArenaView {

    private BorderPane arenaframe;
    
    AboutArenaView(BorderPane arenaframe) {
        this.arenaframe = arenaframe;
        displayAboutArena();
    }
    
    private void displayAboutArena(){
        String info = "Devoution and excellence,\n\n"
                + "The foreground to developing the greatest to be, entertainment plattform.\n"
                + "We want people to feel at home when they use our services, and provide what\n"
                + "other companies apparently can't: Precision, Uniqueness, unambiguousness and quality.\n"
                + "\nI like  buttered toast!";
        
        TextArea textarea = new TextArea(info);
        textarea.setEditable(false);
                textarea.setPrefRowCount(10);
        textarea.setPrefColumnCount(100);
        textarea.setWrapText(true);
        textarea.setPrefWidth(150);
        arenaframe.setCenter(textarea);
    }
    
}
