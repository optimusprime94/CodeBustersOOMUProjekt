/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.exceptions;

/**
 *
 * @author S153298
 */
public class GameIDNotFoundException extends Exception{
    public GameIDNotFoundException(int ID){
        super("Error: GameId " + ID +  "not found in Database");
    }
}
