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
    private GridPane gamesgrid;
    private ArrayList<String> gamelist = new ArrayList<>();
    private int width = 150, height = 250;

    GameLibraryView(BorderPane arenaframe) {
        this.arenaframe = arenaframe;
        gamesgrid = new GridPane();
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

        Iterator it = gamelist.iterator();
        int row = 0;
        /* Itererar igenom alla spel och lägger till deras icon till vyn */
        while (it.hasNext()) {
            for (int i = 0; i < 3; i++) {
                if (!it.hasNext()) {
                    break;
                }
                Image gameImg = new Image("image/icons/game_" + it.next(), 150, 250, false, false);
                gamesgrid.addRow(row, new ImageView(gameImg));
            }
            row++;
        }
        arenaframe.setCenter(gamesgrid);
    }
}
