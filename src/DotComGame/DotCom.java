/*
 * Created by Axel_ST on 09.09.2022
 *
 * Head First Java, 2nd Edition (RU) p. 180
 */

package DotComGame;

import java.util.ArrayList;

public class DotCom {
    //declare and initialize the variables
    private ArrayList <String> locationCells; // list keep location cell position
    private String name;
    
    //declare variables setters
    public void setLocationCells(ArrayList <String> loc) {
        locationCells = loc;
    }
    
    public void setName(String n) {
        name = n;
    }
    
    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput); // find out user guess in locationCells list
        if (index >= 0) { //if locationCell collected result of user input
            locationCells.remove(index); //delete it from list
            if (locationCells.isEmpty()) { //check list condition
                result = "kill"; // if it's empty - return result to win
            } else {
                result = "hit"; // if not empty - result to new try
            }
        }
        return result;
    }
}
