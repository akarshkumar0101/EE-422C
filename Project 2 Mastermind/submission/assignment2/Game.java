/*
 * EE422C Project 2 (Mastermind) submission by
 * Akarsh Kumar
 * ak39969
 * Slip days used: 0
 * Fall 2019
 */
package assignment2;

import java.util.*;

public class Game {

    /**
     * the set of all allowed colors
     */
    private static Set<String> allowedColors;

    static{
        allowedColors = new HashSet<>(GameConfiguration.colors.length);
        for(String color: GameConfiguration.colors){
            allowedColors.add(color);
        }
    }

    private final boolean testingMode;
    private final GameUI gameUI;

    private int numGuessesLeft;
    private String secretCode;

    private final List<Feedback> feedbackHistory;

    /**
     * Create a new game.
     * @param testingMode
     * @param gameUI
     */
    public Game(boolean testingMode, GameUI gameUI){
        this.testingMode = testingMode;
        this.gameUI = gameUI;

        feedbackHistory = new ArrayList<>(GameConfiguration.guessNumber);
    }

    /**
     * Resets the game to a brand new game.
     */
    public void resetGame(){
        resetGame(GameConfiguration.guessNumber);
    }

    /**
     * Init a new game with a numGuesses
     * @param numGuesses
     */
    private void resetGame(int numGuesses){
        numGuessesLeft = numGuesses;
        secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
        feedbackHistory.clear();

        if(testingMode) {
            gameUI.establishedSecretCode(this, secretCode);
        }
    }

    /**
     * Run the actual game
     */
    public void runGame(){
        boolean won = false;
        while(!won && numGuessesLeft>0) {
            String validGuess = getValidGuess();
            numGuessesLeft--;

            Feedback feedback = new Feedback(secretCode, validGuess);
            feedbackHistory.add(feedback);
            gameUI.guessFeedback(this, feedback);

            won = won || secretCode.equals(validGuess);
        }
        if(won){
            gameUI.wonGame(this);
        }
        else{
            gameUI.lostGame(this, secretCode);
        }
    }

    private String getValidGuess(){
        String guess = null;
        boolean validGuess = true;
        do{
            if(!validGuess){
                gameUI.invalidGuess(this);
            }
            guess = gameUI.getNextGuess(this);
            validGuess = isValidGuess(guess);
        }while(!validGuess);
        return guess;
    }

    private boolean isValidGuess(String guess){
        if(guess == null || guess.length()!=GameConfiguration.pegNumber){
            return false;
        }
        for(char color:guess.toCharArray()){
            if(!allowedColors.contains(String.valueOf(color))){
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the feedback history.
     * @return
     */
    public List<Feedback> getFeedbackHistory(){
        return feedbackHistory;
    }

    /**
     * Number of guesses left in this game.
     * @return
     */
    public int getNumGuessesLeft(){
        return numGuessesLeft;
    }

}
