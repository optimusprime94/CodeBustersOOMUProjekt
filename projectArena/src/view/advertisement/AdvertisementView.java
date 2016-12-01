/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.advertisement;

import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    private StackPane advertPane;

    public AdvertisementView(BorderPane arenaframe) {
        this.arenaframe = arenaframe;
        advertPane = new StackPane();
    }

    private void showAdvertisement() {
        Image adImage = new Image(advertisementFile, arenaframe.widthProperty().doubleValue() - 20, 80, false, false);
        ImageView adView = new ImageView(adImage);
        
        adView.setFitWidth(arenaframe.widthProperty().subtract(50).doubleValue());
        adView.setFitHeight(80);
        
        advertPane.getChildren().add(adView);
        advertPane.alignmentProperty().set(Pos.CENTER);
        advertPane.setPadding(new Insets(10,10,10,10));
        adView.xProperty().bindBidirectional(arenaframe.layoutXProperty()); // binder den till arenaframens bredd.
        arenaframe.setBottom(advertPane);

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
