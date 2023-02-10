/*
 * Created by Axel_ST on 09.09.2022
 *
 * Head First Java, 2nd Edition (RU) p. 178
 */

package DotComGame;

import java.util.ArrayList;

public class DotComBust {
    //starting initialization
    private GameHelper helper = new GameHelper();
    private ArrayList <DotCom> dotComsList = new ArrayList <DotCom>();
    private int numOfGuesses = 0;
    
    // method for the initial creation of DotCom objects and provide a user manual.
    private void setUpGame() {
    }
    
    // gameplay method
    private void startPlaying() {
    }
    
    // hit test method
    private void checkUserInput(String userGuess) {
    }
    
    // method of displaying the game result
    private void finishGame() {
    }
    
    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
