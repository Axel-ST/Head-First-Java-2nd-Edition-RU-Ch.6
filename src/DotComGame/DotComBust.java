/*
 * Created by Axel_ST on 09.09.2022
 *
 * Head First Java, 2nd Edition (RU) p. 178
 */

package DotComGame;

import java.util.ArrayList;

public class DotComBust {
    //declare and initialize the variables
    private GameHelper helper = new GameHelper();
    private ArrayList <DotCom> dotComsList = new ArrayList <DotCom>();
    private int numOfGuesses = 0;
    
    // method for the initial creation of DotCom objects and provide a user manual.
    private void setUpGame() {
        //make 3 objects, give them names, gut them in the ArrayList.
        DotCom one = new DotCom();
        DotCom two = new DotCom();
        DotCom three = new DotCom();
        one.setName("blinkee.com");
        two.setName("patimex.com");
        three.setName("milliondollarhomepage.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        //print brief instructions for user
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("blinkee.com, patimex.com, millionDollarHomepage.com");
        System.out.println("Try to sink them all in the fewest number of guesses.");
        // set locations for each DotCom object in ArrayList
        for (DotCom dotComToSet : dotComsList) {
            ArrayList <String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells((newLocation));
        }
    }
    
    // gameplay method
    private void startPlaying() {
        while (!dotComsList.isEmpty()) { // communicating with the user before we run out of dot coms
            String userGuess = helper.getUserInput("Enter a guess: ");
            checkUserGuess(userGuess);
        }
        finishGame(); // show results
    }
    
    // hit test method
    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";
        for (DotCom dotComToTest : dotComsList) { // check user shot on each dot com
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("hit")) { // when get hit, get out of the loop
                break;
            }
            if (result.equals("kill")) { // when get kill, delete dotCom from ArrayList and get out of the loop.
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result); // show result of the shot
    }
    
    // method of displaying the game result
    private void finishGame() {
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }
    
    public static void main(String[] args) {
        DotComBust game = new DotComBust(); // create the game object
        game.setUpGame(); // game object set up the game
        game.startPlaying(); //game object start gameplay loop
    }
}
