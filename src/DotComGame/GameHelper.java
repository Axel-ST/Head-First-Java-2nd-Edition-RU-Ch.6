/*
 * Created by Axel_ST on 09.09.2022
 *
 * Head First Java, 2nd Edition (RU) p. 182
 */

package DotComGame;

import java.io.*;
import java.util.ArrayList;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private final int gridLength = 7;
    private final int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;
    
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        if (inputLine != null) {
            return inputLine.toLowerCase();
        } else {
            return null;
        }
    }
    
    public ArrayList <String> placeDotCom(int comSize) {
        ArrayList <String> alphaCells = new ArrayList <String>(); // hold 'f6' type coords
        String temp = null; // temporary String for concat
        int[] coords = new int[comSize]; // current candidate coords
        int attempts = 0; // current attempts count
        boolean success = false; // flag = found a good location?
        int location = 0; // current starting location
        
        comCount++; // n-th dot com to place
        int incr = 1; //horizontal increment
        if (comCount % 2 == 1) { // if odd dot com - place vertically
            incr = gridLength; // vertical increment
        }
        
        while (!success & attempts++ < 200) { // main search loop
            location = (int) (Math.random() * gridSize); // get random starting point
            // System.out.println(" try " + location);
            int x = 0; // n-th position in dot com to place
            success = true; //assume success
            while (success && x < comSize) { // look for adjacent unused spot
                if (grid[location] == 0) { // not already used
                    coords[x++] = location; // save location
                    location += incr; // try next adjacent
                    if (location >= gridSize) { //out of bounds - bottom
                        success = false;
                    }
                    if (x > 0 && location % gridLength == 0) { //out of bounds - right edge
                        success = false;
                    }
                } else { // location already used
                    // System.out.println(" used " + location);
                    success = false;
                }
            }
        }
        int x = 0; //turn location into alpha coords
        int row = 0;
        int column = 0;
        // System.out.println("\n");
        while (x < comSize) {
            grid[coords[x]] = 1; // mark master grid pts. as 'used'
            row = (coords[x] / gridLength); // get row value
            column = coords[x] % gridLength; // get numeric column value
            temp = String.valueOf(alphabet.charAt(column)); // convert to alpha
            
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            // System.out.println(" coords " + x + " = " + alphaCells.get(x - 1));
        }
        // System.out.println("\n");
        return alphaCells;
    }
}
