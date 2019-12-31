/*
 * EE422C Project 2 (Mastermind) submission by
 * Akarsh Kumar
 * ak39969
 * Slip days used: 0
 * Fall 2019
 */
package assignment2;

/**
 * GameUI is an interface that classes can implement in order to become a legitimate UI for the Mastermind Game.
 * The methods in here can block, etc, and will be called by the game at the appropriate times.
 */
public interface GameUI {

    /**
     * Greet the user however you want.
     * @param game
     */
    public abstract void greetUser(Game game);

    /**
     * Ask user if they want to play a new game and return the result.
     * @param game
     * @return
     */
    public abstract boolean askNewGame(Game game);

    /**
     * Tell the UI that a secretCode has been established. (Will only be called if game is not in testing mode).
     * @param game
     * @param secretCode
     */
    public abstract void establishedSecretCode(Game game, String secretCode);

    /**
     * Retrieve the next guess from the user with your UI.
     * @param game
     * @return
     */
    public abstract String getNextGuess(Game game);

    /**
     * After a guess has been retrieved, the game will call this method to inform the UI of the feedback generated.
     * @param game
     * @param feedback
     */
    public abstract void guessFeedback(Game game, Feedback feedback);

    /**
     * Game will inform the UI of an invalid guess with this method.
     * @param game
     */
    public abstract void invalidGuess(Game game);

    /**
     * Game will inform the UI that the user has lost the game.
     * @param game
     * @param secretcode
     */
    public abstract void lostGame(Game game, String secretcode);

    /**
     * Game will inform the UI that the user has won the game.
     * @param game
     */
    public abstract void wonGame(Game game);

}
