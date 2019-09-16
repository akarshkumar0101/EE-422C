package assignment2;

import java.util.*;

public class ConsoleGameUI implements GameUI {

    public static final Scanner inputScanner;

    static {
        inputScanner = new Scanner(System.in);
    }

    private static final String YES_STR = "Y", NO_STR = "N", HISTORY_STR = "HISTORY";


    @Override
    public void greetUser(Game game) {
        System.out.println("Welcome to Mastermind.");
    }

    @Override
    public boolean askNewGame(Game game) {
        //not recursive because invalid input might occur more than once
        while(true) {

            System.out.println("Do you want to play a new game? (Y/N):");
            String newGameInp = inputScanner.nextLine();

            if (NO_STR.equalsIgnoreCase(newGameInp)) {
                return false;
            } else if (YES_STR.equalsIgnoreCase(newGameInp)) {
                return true;
            }
            else{
                System.out.println("Invalid input.");
            }
        }
    }

    @Override
    public void establishedSecretCode(Game game, String secretCode) {
        System.out.println("Secret code: " + secretCode);
    }

    @Override
    public String getNextGuess(Game game) {
        System.out.println("\nYou have "+game.getNumGuessesLeft()+" guess(es) left.");
        System.out.println("Enter guess: ");
        String input = inputScanner.nextLine();
        if(HISTORY_STR.equalsIgnoreCase(input)){
            processFeedbackHistoryRequest(game);
            return getNextGuess(game);
        }
        else{
            return input;
        }
    }

    @Override
    public void guessFeedback(Game game, Feedback feedback) {
        outFeedback(feedback);
    }


    private void processFeedbackHistoryRequest(Game game){
        List<Feedback> feedbackHistory = game.getFeedbackHistory();
        for(Feedback feedback: feedbackHistory){
            outFeedback(feedback);
        }
    }

    private void outFeedback(Feedback feedback){
        String feedbackStr = feedback.numBlack()+"b_"+feedback.numWhite()+"w";
        System.out.println(feedback.getValidGuess()+" -> "+feedbackStr);
    }

    @Override
    public void invalidGuess(Game game) {
        System.out.println("INVALID_GUESS");
    }

    @Override
    public void lostGame(Game game, String secretCode) {
        System.out.println("You lose! The pattern was "+secretCode);
    }

    @Override
    public void wonGame(Game game) {
        System.out.println("You win!");
    }
}
