package bcc.battleship;

public class Grid {
    private Location spot[][];
    
    
    
    // Create a new Grid and initialize each Location.
    public Grid() {
        spot = new Location[Constants.NUM_ROWS][Constants.NUM_COLS];
        for (int i = 0; i < spot.length; i++){
            for(int j = 0; j < spot[0].length; j++){
                spot[i][j] = new Location();
            }
        }
    }
    
    // Mark a hit in the specified Location.
    public void markHit(int row, int col) {
        spot[row][col].markHit();
       
    }
    
    // Mark a miss in the specified location.
    public void markMiss(int row, int col) {
        spot[row][col].markMiss();

    }
    
    // Set the status of the Location at (row, col).
    public void setStatus(int row, int col, int status) {
        spot[row][col].setStatus(status);

    }
    
    // Get the status of the Location at (row, col).
    public int getStatus(int row, int col) {
        return spot[row][col].getStatus();
    }
    
    // Return whether this Location has already been guessed.
    public boolean alreadyGuessed(int row, int col) {
        if(spot[row][col].getStatus() != Constants.UNGUESSED){
            return true;
        }
        return false;
    }
    
    // Set whether there is a ship at this location.
    public void setShip(int row, int col, boolean val) {
        spot[row][col].setShip(val);

    }
    
    // Return whether there is a ship at this location.
    public boolean hasShip(int row, int col) {
        return spot[row][col].hasShip();
    }
    
    // Get the Location object at this row and column.
    public Location get(int row, int col) {
        return spot[row][col];
    }
    
    // Return the number of rows.
    public int numRows() {
        return spot.length;
    }
    
    // Return the number of columns.
    public int numCols() {
        return spot[0].length;
    }
    

    //maybe convert to boolean?
    public boolean addShip(Ship s) {
        int row = s.getRow();
        int col = s.getCol();
        int length = s.getLength();
        int direction = s.getDirection();
        if(direction == Constants.UNSET){
            return false;
        }
        if(row == Constants.UNSET){
            return false;
        }
        if(col == Constants.UNSET){
            return false;
        }
        if(row + length >= spot[0].length && direction == Constants.VERTICAL){
            return false;
        }
        if(col + length >= spot.length && direction == Constants.HORIZONTAL){
            return false;
        }
        if(direction == Constants.VERTICAL){
            for(int i = row; i < row + length; i++){
                if(hasShip(i, col)){
                    return false;
                }
            }
            for(int i = row; i < row + length; i++){
                setShip(i, col, true);
            }
            return true;
        }
        if(direction == Constants.HORIZONTAL){
            for(int i = col; i < col + length; i++){
                if(hasShip(row, i)){
                    return false;
                }
            }
            for(int i = col; i < col + length; i++){
                setShip(row, i, true);
            }
            return true;
        }
        return false;
    }

    public boolean allShipsSank(){
        for(int i = 0; i < spot.length; i++){
            for(int j = 0; j < spot[0].length; j++){
                if(spot[i][j].hasShip() && spot[i][j].getStatus() == Constants.UNGUESSED){
                    return false;
                }
            }
        }
        return true;
    }
}
