/*
 * EE422C Project 2 (Mastermind) submission by
 * Akarsh Kumar
 * ak39969
 * Slip days used: 0
 * Fall 2019
 */
package assignment2;

import java.util.HashSet;
import java.util.Set;

/**
 * Holds a guess from the user, and the associated feedback from it.
 */
public class Feedback {

    private final String secretCode;
    private final String validGuess;

    private final int black;
    private final int white;

    /**
     * Creates feedback given the secret code and the guess.
     * @param secretCodeStr
     * @param validGuessStr
     */
    public Feedback(String secretCodeStr, String validGuessStr){
        this.secretCode = secretCodeStr;
        this.validGuess = validGuessStr;

        Set<Character> secretCodeSet = new HashSet<>();
        for(char c: secretCodeStr.toCharArray()){
            secretCodeSet.add(c);
        }

        int black = 0, white = 0;

        StringBuilder secretCode = new StringBuilder(secretCodeStr);
        StringBuilder validGuess = new StringBuilder(validGuessStr);
        for(int i=0;i<GameConfiguration.pegNumber;i++){
            if(secretCode.charAt(i)==validGuess.charAt(i)){
                black++;//black peg
                secretCode.replace(i,i+1, "!");
                validGuess.replace(i,i+1, "!");
            }
        }
        for(int i=0;i<GameConfiguration.pegNumber;i++){
            //does not match
            char c = validGuess.charAt(i);
            if(c=='!'){
                //ignore the waste characters
                continue;
            }
            for(int j = 0; j <GameConfiguration.pegNumber;j++){
                if(c==secretCode.charAt(j)){
                    //found a mismatched one
                    white++;
                    secretCode.replace(j,j+1, "!");
                    validGuess.replace(i,i+1, "!");
                    break;
                }
            }

        }


        this.black = black;
        this.white = white;
    }

    /**
     * @return the number of black pegs
     */
    public int numBlack(){
        return black;
    }
    /**
     * @return the number of white pegs
     */
    public int numWhite(){
        return white;
    }
    /**
     * @return the valid guess fed from which the feedback was created.
     */
    public String getValidGuess(){
        return validGuess;
    }
}
