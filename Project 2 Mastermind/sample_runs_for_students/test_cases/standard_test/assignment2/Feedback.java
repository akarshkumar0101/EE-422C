package assignment2;

import java.util.HashSet;
import java.util.Set;

public class Feedback {

    private final String secretCode;
    private final String validGuess;

    private final int black;
    private final int white;


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


    public int numBlack(){
        return black;
    }
    public int numWhite(){
        return white;
    }
    public String getValidGuess(){
        return validGuess;
    }
}
