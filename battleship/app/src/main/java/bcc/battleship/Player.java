package bcc.battleship;
import bcc.battleship.Constants;

public class Player {
    private Ship[] mine;
    private Grid user;
    private Grid opponent;
  
    // Constructor: Initialize the grids and the ships.
    public Player() {
        mine = new Ship[5];
        for(int i = 0; i < Constants.SHIP_LENGTHS.length; i++){
            mine[i] = new Ship(Constants.SHIP_LENGTHS[i]);
        }
        user = new Grid();
        opponent = new Grid();

    }
    
    /**
     * This method is used for testing to set a ship's location.
     * It sets the ship's row, column, and direction, then adds it to the player's grid.
     *
     */
    
    public boolean chooseShipLocation(int index, int row, int col, int direction) {
        mine[index].setLocation(row, col);
        mine[index].setDirection(direction);
        return user.addShip(mine[index]);
    }
   
    /**
     * Record a guess from the opponent.
     * This method checks the player's grid at (row, col). If there is a ship,
     * it marks a hit and returns true; otherwise, it marks a miss and returns false.
     *
     */
    public boolean recordOpponentGuess(int row, int col) {
        if(user.hasShip(row, col)){
            user.markHit(row, col);
            return true;
        }
        user.markMiss(row, col);
        return false;
    }
    
    
    public Grid getMyGrid() {
        return user;
    }
    
    public Grid getOpponentGrid() {
        return opponent;
    }
}
