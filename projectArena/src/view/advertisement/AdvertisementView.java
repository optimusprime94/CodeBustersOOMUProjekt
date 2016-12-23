/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.advertisement;

import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.advertisement.Advertisement;
import model.advertisement.GetAdvertisment;

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
    private String[] filepaths = {"image/VisitorAd.gif", "image/darkgrey.jpg", "image/gladiator.jpg", "image/lightTheme1.jpg"};
    private int[] times = {5000,9000,3000,7000};
    private int adIndex = 0;
    private ArrayList<Advertisement> adverts;

    
    public AdvertisementView(BorderPane arenaframe) {
        this.arenaframe = arenaframe;
        advertPane = new StackPane();
        GetAdvertisment getAds = new GetAdvertisment();
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
                //filepath = filepath % 2;
                //System.out.println(filepath);
                //switchAd(filepaths[filepath++]);
                //System.out.println(filepath);
                
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
        adImage = new Image(advertisementFile, arenaframe.widthProperty().doubleValue() - 20, 80, false, false);
        
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
    
