/*
 * EE422C Project 2 (Mastermind) submission by
 * Akarsh Kumar
 * ak39969
 * Slip days used: 0
 * Fall 2019
 */
package assignment2;

import java.util.Scanner;

public class Driver {
    /**
     * If we are in testing mode or not
     */
    public static boolean testingMode = false;

    /**
     * Main method
     * @param args
     */
    public static void main(String... args){
        //get testing mode from command line
        if(args.length>0){
            if("1".equals(args[0])){
                testingMode = true;
            }
        }

        //ConsoleGameUI is one implementation of GameUI used for this project
        GameUI gameUI = new ConsoleGameUI();
        Game game = new Game(testingMode, gameUI);

        //greet user once
        gameUI.greetUser(game);

        //multiple games loop
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

