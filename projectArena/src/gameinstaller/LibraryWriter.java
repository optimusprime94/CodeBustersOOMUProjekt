/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameinstaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author s153298
 */


public class LibraryWriter {
    

    private PrintWriter printer;
    
    public LibraryWriter(String output) throws FileNotFoundException{
        File outputFile = new File(output);
        try {
            printer = new PrintWriter(outputFile);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }
    }
    
    private void printOutput(String output){
        printer.println(output);
    }

    private void printOutput(int output){
        printer.println(output);
    }

    private void printGame(Game game){
        int gameId = game.getGameId();
        String gameName = game.getGameName();

        printOutput(gameId);
        printOutput(gameName);
        if(game.getGameVisibility())
            printOutput("Visible");
        else printOutput("Invisible");
    }
    
    public void writeLibrary(ArrayList<Game> gameList, int size){
        printOutput(gameList.size());
        for(int i = 0; i < gameList.size(); i++){
            printGame(gameList.get(i));
        }
        printer.close();
    }
}