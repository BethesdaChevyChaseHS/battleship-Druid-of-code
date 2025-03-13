package bcc.battleship;

public class Location {
    // Instance variables
    private boolean IsShip;
    private int status;

    // Constructor. Initializes with no ship and status UNGUESSED.
    public Location() {
        IsShip = false;
        status = Constants.UNGUESSED;

    }

    // Was this Location a hit?
    public boolean checkHit() {
        if(status == Constants.HIT){
            return true;
        }
        return false;
    }

    // Was this location a miss?
    public boolean checkMiss() {
        if(status == Constants.MISSED){
            return true;
        }
        return false;
    }

    // Was this location unguessed?
    public boolean isUnguessed() {
        if(status == Constants.UNGUESSED){
            return true;
        }
        return false;
    }

    // Mark this location as a hit.
    public void markHit() {
        status = Constants.HIT;
    }

    // Mark this location as a miss.
    public void markMiss() {
        status = Constants.MISSED;

    }

    // Return whether or not this location has a ship.
    public boolean hasShip() {
        return IsShip;
    }

    // Set whether this location has a ship.
    public void setShip(boolean val) {
        IsShip = val;

    }

    // Set the status of this Location.
    public void setStatus(int status) {
        this.status = status;

    }

    // Get the status of this Location.
    public int getStatus() {
        return status;
    }
}
