package assignment2;

import java.util.Scanner;

public class Driver {
    public static final boolean testingMode = true;

    public static void main(String... args){
        GameUI gameUI = new ConsoleGameUI();
        Game game = new Game(testingMode, gameUI);

        gameUI.greetUser(game);

        while(true){
            boolean wantsNewGame = gameUI.askNewGame(game);
            if(!wantsNewGame){
                break;
            }

            //start the game

            game.resetGame();
            game.runGame();
        }

    }
}

