package assignment2;

import java.util.Scanner;

public class Driver {
    public static boolean testingMode = false;

    public static void main(String... args){
        if(args.length>0){
            if("1".equals(args[0])){
                testingMode = true;
            }
        }


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

