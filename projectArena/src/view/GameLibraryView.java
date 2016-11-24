/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

/**
 *
 * @author S143522 (Elvir Dzeko)
 */
class GameLibraryView {

    private BorderPane arenaframe;
    private GridPane gamesgrid;
    private ArrayList<String> gamelist;
    private ScrollPane scrollpane;
    private int width = 150, height = 250;

    GameLibraryView(BorderPane arenaframe) {
        this.scrollpane = new ScrollPane();
        this.arenaframe = arenaframe;
        this.gamesgrid = new GridPane();
        this.gamelist = new ArrayList<>();
    }

    public void showGameLibrary() {

        /* gap: mellanrum mellan ikonerna (i pixlar), och padding är mellanrum runt gridens kanter.*/
        gamesgrid.setHgap(15);
        gamesgrid.setVgap(15);
        gamesgrid.setPadding(new Insets(50, 15, 15, 50)); // top, right, bottom, left: mellanrum för gridens kanter.

        /* rensar allt i gamesgrid och gamelist, innan spelen uppdateras. */
        gamesgrid.getChildren().clear();
        gamelist.clear();
        /* lägg till spel efter här: */

        gamelist.add("pacmanv3.png");
        gamelist.add("assassinscreed2v3.png");
        gamelist.add("assassinscreed2v3.png");
        gamelist.add("assassinscreed2v3.png");
        gamelist.add("assassinscreed2v3.png");
        gamelist.add("assassinscreed2v3.png");
        gamelist.add("assassinscreed2v3.png");
        gamelist.add("assassinscreed2v3.png");
        gamelist.add("assassinscreed2v3.png");
        gamelist.add("assassinscreed2v3.png");

        Iterator it = gamelist.iterator(); // för att iterera genom spelen.
        int row = 0;
        /* Itererar igenom alla spel och lägger till deras icon till vyn */
        while (it.hasNext()) {
            for (int i = 0; i <= 3; i++) {
                if (!it.hasNext()) {
                    break;
                }

                Image gameImg = new Image("image/icons/game_" + it.next(), 150, 250, false, false);
                ImageView gameView = new ImageView(gameImg);
                gamesgrid.addRow(row, gameView);

                Color color = colorHighlight(i);

           
                
                gameView.setOnMouseEntered(e -> gameView.setEffect(new DropShadow(15, color)));
                gameView.setOnMouseExited(e -> gameView.setEffect(new DropShadow(15, Color.TRANSPARENT)));

                if (i == 0) {
                    gameView.setOnMouseClicked(e -> {
                        try {                                                   
                            ProcessBuilder pb = new ProcessBuilder("java", "-jar", "Grupp01Othello.jar");
                            pb.directory(new File("C:\\Users\\elvir\\Documents\\NetBeansProjects\\CodeBustersOOMUProjekt\\projectArena")); //Viktigt! Ändra här för varje dator!
                            Process p = pb.start();

                            //Process p2 = new ProcessBuilder("C:\\Users\\elvir\\Documents\\NetBeansProjects\\CodeBustersOOMUProjekt\\projectArena\\Grupp01Othello.jar").start();
                        } catch (IOException ex) {
                            Logger.getLogger(ArenaFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }
            row++;
        }
        setupScrollbar();
    }

    private void setupScrollbar() {
        scrollpane.setContent(gamesgrid);
        arenaframe.setCenter(scrollpane);
    }
    
    
    private Color colorHighlight(int number){
        switch(number){
            case 0: return Color.DARKGREEN;
            case 1: return Color.DARKRED;
            case 2: return Color.DARKBLUE;
            case 3: return Color.DARKCYAN;
            default: return Color.WHITE;
        }
    }
}
