/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameinstaller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nick
 */
public class Library {
    private ArrayList<Game> gamesLibrary;
    private int size;
    private LibraryReader reader;
    private LibraryWriter writer;
    private int nextId = 0;
    
    
    public Library(String libraryFile){
        try {
            reader = new LibraryReader(libraryFile);
            size = Integer.valueOf(reader.getInput());
            writer = new LibraryWriter(libraryFile);
            gamesLibrary = new ArrayList<>();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void initializeLibrary(){
        reader.readLibrary(gamesLibrary, size);
        setNextId();
    }
    
    public void printLibrary(){
        writer.writeLibrary(gamesLibrary, size);
    }
    public void installNewGame(Game newGame){
        gamesLibrary.add(newGame);
        size++;
        setNextId();
    }
    
    private void setNextId(){
        for(int i = 0; i < size; i++){
            if (gamesLibrary.get(i).getGameId() >= nextId)
                nextId = gamesLibrary.get(i).getGameId() + 1;
        }
    }
    public int generateNewId(){
        return nextId++;
    }
    public void deleteGame(Game gameToBeDeleted){
//        int i;
//        for(i = 0; i < size; i++){
//            if (gamesLibrary[i].equals(gameToBeDeleted)){
//                size--;
//                break;
//            }
//        }
//        for(int j = i; j < size; j++){
//            gamesLibrary[j] = gamesLibrary[j+1];
//        }
                    gamesLibrary.remove(gameToBeDeleted);
                    size--;
    }
    public Game getGame(int id) throws GameIDNotFoundException{
        for(int i = 0; i < size; i++){
            if (gamesLibrary.get(i).getGameId() == id)
                return gamesLibrary.get(i);
        }
        throw new GameIDNotFoundException(id);
    }
}