/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.userviews;

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
import model.play.PlayMatch;

/**
 *
 * @author S143522 (Elvir Dzeko)
 */
class GameLibraryView {

    /* Attributes */
    private BorderPane arenaframe;
    private GridPane gamesgrid;
    private Library gamelib;
    private ScrollPane scrollpane;
    private int width = 150, height = 250;

    /* Konstruktor */ 
    GameLibraryView(BorderPane arenaframe) {
        this.scrollpane = new ScrollPane();
        this.arenaframe = arenaframe;
        this.gamesgrid = new GridPane();
        this.gamelib = new Library();
    }

    public void showGameLibrary() {

        ArrayList<Game> gamelist = new ArrayList<>();
        /* gap: between the icons (in pixels), and padding arround the borders */
        gamesgrid.setHgap(15);
        gamesgrid.setVgap(15);
        gamesgrid.setPadding(new Insets(50, 15, 15, 50)); // top, right, bottom, left: around grid borders.

        /* clears the gamesgrid before games are added */
        gamesgrid.getChildren().clear();
        gamelist = gamelib.getgameLibrary();
        /* add games after this: */

        Iterator it = gamelist.iterator(); // iterator for the games
        int row = 0;
        /* iterates through the games and adds them */
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
                    new PlayMatch(game);
                });

            }
            row++;
        }
        setupScrollbar();
    }

    /**
     * inserts the scrollbar in the mainframe.
     */
    private void setupScrollbar() {
        scrollpane.setContent(gamesgrid);
        arenaframe.setCenter(scrollpane);
    }

    /**
     * Color highlights for the icons.
     * @param number a number for which color.
     * @return 
     */
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
