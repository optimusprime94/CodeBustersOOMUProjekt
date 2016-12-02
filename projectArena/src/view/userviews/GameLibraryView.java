/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.userviews;

import controller.GameStarter;
import model.administration.Game;
import model.administration.Library;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.play.Match;

/**
 *
 * @author S143522 (Elvir Dzeko)
 */
class GameLibraryView {

    private BorderPane arenaframe;
    private GridPane gamesgrid;
    private Library gamelib;
    private ScrollPane scrollpane;
    private int width = 150, height = 250;

    GameLibraryView(BorderPane arenaframe) {
        this.scrollpane = new ScrollPane();
        this.arenaframe = arenaframe;
        this.gamesgrid = new GridPane();
        this.gamelib = new Library();
    }

    public void showGameLibrary() {

        ArrayList<Game> gamelist = new ArrayList<>();
        /* gap: mellanrum mellan ikonerna (i pixlar), och padding är mellanrum runt gridens kanter.*/
        gamesgrid.setHgap(15);
        gamesgrid.setVgap(15);
        gamesgrid.setPadding(new Insets(50, 15, 15, 50)); // top, right, bottom, left: mellanrum för gridens kanter.

        /* rensar allt i gamesgrid och gamelist, innan spelen uppdateras. */
        gamesgrid.getChildren().clear();
//        gamelist.clear();
        gamelist = gamelib.getgameLibrary();
        /* lägg till spel efter här: */

//        gamelist.add(new Game("Othello", "1", "src/gamelib","image/icons/game_othello.png"));
        Iterator it = gamelist.iterator(); // för att iterera genom spelen.
        int row = 0;
        /* Itererar igenom alla spel och lägger till deras icon till vyn */
        while (it.hasNext()) {
            for (int i = 0; i <= 3; i++) {
                if (!it.hasNext()) {
                    break;
                }
                Game game = (Game) it.next();
                Image gameImg = new Image(game.getImagePath(), 150, 250, false, false);
                ImageView gameView = new ImageView(gameImg);
                gamesgrid.addRow(row, gameView);

                Color color = colorHighlight(i);

                gameView.setOnMouseEntered(e -> gameView.setEffect(new DropShadow(15, color)));
                gameView.setOnMouseExited(e -> gameView.setEffect(new DropShadow(15, Color.TRANSPARENT)));

                gameView.setOnMouseClicked(e -> {
                    new Match(game);
                });

            }
            row++;
        }
        setupScrollbar();
    }

    private void setupScrollbar() {
        scrollpane.setContent(gamesgrid);
        arenaframe.setCenter(scrollpane);
    }

    private Color colorHighlight(int number) {
        switch (number) {
            case 0:
                return Color.DIMGREY;
            case 1:
                return Color.DIMGREY;
            case 2:
                return Color.DIMGREY;
            case 3:
                return Color.DIMGREY;
            default:
                return Color.WHITE;
        }
    }
}
