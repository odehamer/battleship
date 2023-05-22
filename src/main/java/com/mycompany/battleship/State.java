/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.battleship;

/**
 *
 * @author oscar
 */
public class State {
    private int gameState = Constants.STANDBY;

    public void setGameState(int newGameState) {
        this.gameState = newGameState;
    }
    
    public int getGameState() {
        return this.gameState;
    }
    
    
    
}
