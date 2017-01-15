/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.general.LoginView;

/**
 *
 * @author S143534
 */
public class StartView extends ArenaView {

    protected BorderPane frame;
    LoginView loginview;

    public StartView(Stage stage) {
        super(stage);
        this.frame = super.arenaframe;

        loginview = new LoginView(super.stage);
        frame.setCenter(loginview.getLoginView());
        setHomeButton();
    }

/**
 * setHomeButton 
 */
    private void setHomeButton() {
        /* om det är startview som visas så ska hemknappen komma till login-sidan,
           ifall man klickat på andra meny knappar. */
        super.homeItem.setOnAction(e -> frame.setCenter(loginview.getLoginView()));
    }

}
