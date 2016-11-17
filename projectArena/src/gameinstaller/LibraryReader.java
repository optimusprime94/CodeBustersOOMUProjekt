/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameinstaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nick
 */
public class LibraryReader {
    private Scanner in;
    
    public LibraryReader(String input) throws FileNotFoundException{
        File inputFile = new File(input);
        try {
            in = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }
    }
    

    protected String getInput(){
        if (in.hasNextLine()){
            return(in.nextLine());
        }
        else {
            System.out.println("End of file reached");
            return null;
        }
    }
    
    
    public void readLibrary(ArrayList<Game> gameList, int size){
        getInput();
        while(in.hasNext()){
            gameList.add(new Game(getInput(),getInput(),getInput()));
        }
    }
}
