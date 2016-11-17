/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author S143522 (Elvir Dzeko)
 */
class GameLibraryView {

    private BorderPane arenaframe;
    private int imageSize = 100;
    private ArrayList<String> gamelist;

    GameLibraryView(BorderPane arenaframe) {
        this.arenaframe = arenaframe;
        gamelist = new ArrayList<>();
    }

    public void showGameLibrary() {
        GridPane gamesgrid = new GridPane();
        gamesgrid.setHgap(15); //horizontal gap in pixels => that's what you are asking for
        gamesgrid.setVgap(15); //vertical gap in pixels
        gamesgrid.setPadding(new Insets(50, 15, 15, 50)); // top, right, bottom, left: mellanrum för gridens kanter.
       // Image i1 = new Image("image/icons/game_othello2.png", imageSize, imageSize, false, false);

        //illfälligt
        gamelist.add("othello2.png");
        gamelist.add("pacman2.png");
        gamelist.add("assassinscreed2.png");
        
        Iterator it = gamelist.iterator();
        int row = 0;
        /* Itererar igenom alla spel och lägger till deras icon till vyn */
        while (it.hasNext()) {
            for (int i = 0; i < 3; i++) {
                if(!it.hasNext()) break;
                Image gameImg = new Image("image/icons/game_" + it.next(), imageSize, imageSize, false, false);
                gamesgrid.addRow(row, new ImageView(gameImg));
            }
            row++;
        }
        arenaframe.setCenter(gamesgrid);
    }
}
