/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.advertisement;

import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import model.advertisement.Advertisement;
import model.advertisement.GetAdvertisement;

/**
 *
 * @author S143522 (Elvir Dzeko)
 */
public class AdvertisementView {

    private String advertisementFile;
    private BorderPane arenaframe; //referens till arenas huvud frame.
    private StackPane advertPane;
    private ImageView adView;
    private Image adImage;
    private int adIndex = 0;
    private ArrayList<Advertisement> adverts;

    
    public AdvertisementView(BorderPane arenaframe) {
        this.arenaframe = arenaframe;
        advertPane = new StackPane();
        GetAdvertisement getAds = new GetAdvertisement();
        this.adverts = getAds.getAdverts();
        
    }

    private void showAdvertisement() {
        adImage = new Image(advertisementFile, arenaframe.widthProperty().doubleValue() - 20, 80, false, false);
        adView = new ImageView(adImage);
        
        adView.setFitWidth(arenaframe.widthProperty().subtract(50).doubleValue());
        adView.setFitHeight(80);
        
        advertPane.getChildren().add(adView);
        advertPane.alignmentProperty().set(Pos.CENTER);
        advertPane.setPadding(new Insets(10,10,10,10));
        adView.xProperty().bindBidirectional(arenaframe.layoutXProperty()); // binder den till arenaframens bredd.
        arenaframe.setBottom(advertPane);
        new RunAdScheme();                                                      // Bug, process does not end upon exit

        advertPane.setOnMouseClicked(e -> {
            
            try {
                System.out.print("ad clicked!");
                Desktop desktop = java.awt.Desktop.getDesktop();
                URI advertisementURI = new URI(adverts.get(adIndex).getUrl());
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
    
    public void switchAd(String newAd){
        
        advertPane.getChildren().removeAll();
        advertPane.getChildren().clear();
        this.advertisementFile = newAd;
        adImage = new Image("view/"+advertisementFile, arenaframe.widthProperty().doubleValue() - 20, 80, false, false);
        adView = new ImageView(adImage); 
        advertPane.getChildren().add(adView);

    }


    public class RunAdScheme {
        public RunAdScheme() {
            new Thread(() -> { // lambda expression
                try {
                    while (true) {
                        //switchAd(filepaths[filepath++]);
                        adIndex = (adIndex + 1) % adverts.size();
                        Platform.runLater(() -> switchAd(adverts.get(adIndex).getFilePath())); // lambda expression
                        Thread.sleep(Integer.parseInt(adverts.get(adIndex).getTime()));
                    }
                }
                catch (InterruptedException ex) {
                }
            }).start();
        }
    }
}
    
