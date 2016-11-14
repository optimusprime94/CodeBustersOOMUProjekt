/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
    }

    public void setAdvertisement(String newAdvert) {
        this.advertisementFile = newAdvert;
        showAdvertisement();
      
    }

}
