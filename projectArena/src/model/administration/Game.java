/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.administration;

import model.exceptions.GameIDNotFoundException;

/**
 *
 * @author S153298
 */
public class Game {

    private boolean visibleToPublic = false;
    private String gameName;
    private int gameId;
    private String gamePath;
    private String imagePath;


    public Game(String name, String visibleToPublic, String gamePath, String imagePath ) {
        this.gameName = name;
        if (visibleToPublic.equals("1")) {
            this.visibleToPublic = true;
        } else if (visibleToPublic.equals("0")) {
            this.visibleToPublic = false;
        }
        this.gamePath = gamePath;
        this.imagePath = imagePath;
    }

    public Game(String gameId, String gameName, String visibleToPublic, String gamePath, String imagePath) {
        this.gameId = Integer.valueOf(gameId);
        this.gameName = gameName;
        if (visibleToPublic.equals("1")) {
            this.visibleToPublic = true;
        } else if (visibleToPublic.equals("0")) {
            this.visibleToPublic = false;
        }
        this.gamePath = gamePath;
        this.imagePath = imagePath;
    }

    public void setGameVisibility(boolean visibleToPublic) {
        this.visibleToPublic = visibleToPublic;
    }

    public String getGameName() {
        return gameName;
    }

    public int getGameId() {
        return gameId;
    }

    public boolean getGameVisibility() {
        return visibleToPublic;
    }
    
    public String getGamePath(){
        return this.gamePath;
    }
    
    public String getImagePath(){
        return this.imagePath;
    }
}
