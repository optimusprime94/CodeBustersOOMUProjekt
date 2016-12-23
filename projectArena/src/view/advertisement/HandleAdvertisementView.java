/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.advertisement;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import view.administration.InstallGameView;

/**
 *
 * @author S153298
 */
public class HandleAdvertisementView {
    private BorderPane arenaFrame;

    public HandleAdvertisementView(BorderPane arenaFrame) {
        this.arenaFrame = arenaFrame;

        Button addAd = new Button("Add Advertisement");
        Button deleteAd = new Button("Delete Advertisement");
        /* min bredd för lite enformighet. */
        addAd.setMaxWidth(Double.MAX_VALUE);
        deleteAd.setMaxWidth(Double.MAX_VALUE);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(10);
        arenaFrame.setCenter(vBox);
        vBox.getChildren().addAll(addAd, deleteAd);
        addAd.setOnAction(e -> {
            AddAdvertisementView installView = new AddAdvertisementView(arenaFrame);
            arenaFrame.getChildren().remove(vBox);
        });

    }

}
