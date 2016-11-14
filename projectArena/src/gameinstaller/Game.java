/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameinstaller;

/**
 *
 * @author S153298
 */
public class Game {

    private boolean visibleToPublic = false;
    private String gameName;
    private int gameId;


    public Game(String name, Library library) {
        this.gameName = name;
        this.gameId = library.generateNewId();
    }

    public Game(String gameId, String gameName, String visibleToPublic) {
        this.gameId = Integer.valueOf(gameId);
        this.gameName = gameName;
        if (visibleToPublic.equals("Visible")) {
            this.visibleToPublic = true;
        } else if (visibleToPublic.equals("Invisible")) {
            this.visibleToPublic = false;
        }
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

    private String getGameName(int gameID) throws GameIDNotFoundException {
        switch (gameID) {
            case 1:
                return "John Matanda Football '93";
            case 2:
                return "Markus of the Ninja";
            case 3:
                return "Rise of the Felix";
            case 4:
                return "South Park: The Nick of Truth";
            case 5:
                return "Elvir Legacy";
            case 6:
                return "Assassins Elvir 3";
            case 7:
                return "Cooking Matanda";
            case 8:
                return "Felix Wright";
            default:
                throw new GameIDNotFoundException(gameID);
        }
    }

}
