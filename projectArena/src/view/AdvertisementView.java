/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Desktop;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author S143522 (Elvir Dzeko)
 */
public class AdvertisementView {

    private String advertisementFile;
    private BorderPane arenaframe; //referens till arenas huvud frame.

    public AdvertisementView(BorderPane arenaframe) {
        this.arenaframe = arenaframe;

    }

    private void showAdvertisement() {
        Image adImage = new Image(advertisementFile, arenaframe.widthProperty().intValue(), 100, false, false);
        ImageView adView = new ImageView(adImage);
        adView.setFitWidth(arenaframe.getWidth());
        arenaframe.setBottom(adView);

        adView.setOnMouseClicked(e -> {
            try {
                System.out.print("ad clicked!");
                Desktop desktop = java.awt.Desktop.getDesktop();
                URI advertisementURI = new URI("http://youtube.com/");
                desktop.browse(advertisementURI);
            } catch (Exception ex) {
                Logger.getLogger(AdvertisementView.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    public void setAdvertisement(String newAdvert) {
        this.advertisementFile = newAdvert;
        showAdvertisement();

    }

}
