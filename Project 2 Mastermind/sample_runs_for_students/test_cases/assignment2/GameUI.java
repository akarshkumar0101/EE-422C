package assignment2;

public interface GameUI {

    public abstract void greetUser(Game game);

    public abstract boolean askNewGame(Game game);

    public abstract void establishedSecretCode(Game game, String secretCode);

    public abstract String getNextGuess(Game game);

    public abstract void guessFeedback(Game game, Feedback feedback);

    public abstract void invalidGuess(Game game);

    public abstract void lostGame(Game game, String secretcode);

    public abstract void wonGame(Game game);

}
