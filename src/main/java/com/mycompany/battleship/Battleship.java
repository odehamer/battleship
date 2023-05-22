/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.battleship;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class Battleship {

    Ships ships = new Ships();
    View view = new View();
    State state = new State();

    public static void main(String[] args) {
        Battleship battleship = new Battleship();
        battleship.run();
    }

    public void run() {
        while (state.getGameState() != Constants.QUIT_PROGRAM) {
            int gameState = state.getGameState();
            if (gameState == Constants.STANDBY) {
                ships.setVisible(true);
                state.setGameState(Constants.PLACE_SHIPS);
            } else if (gameState == Constants.PLACE_SHIPS) {
                if (ships.getNumShips() >= Constants.SHIPS) {
                    state.setGameState(Constants.AI_PLACE_SHIPS);
                    ships.setVisible(false);
                }
            } else if (gameState == Constants.AI_PLACE_SHIPS) {
                view.aiSetShips();
                state.setGameState(Constants.PLAYER_GUESSES);
            } else if (gameState == Constants.PLAYER_GUESSES) {
                view.setVisible(true);
                if (view.getNumShots()) {
                    state.setGameState(Constants.AI_GUESSES);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Battleship.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (gameState == Constants.AI_GUESSES) {
                try {
                    view.setVisible(false);
                    ships.setVisible(true);
                    TimeUnit.SECONDS.sleep(1);
                    ships.aiGuess();
                    TimeUnit.SECONDS.sleep(1);
                    state.setGameState(Constants.PLAYER_GUESSES);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Battleship.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {

                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }

    }
}
