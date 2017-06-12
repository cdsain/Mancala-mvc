package nl.sogyo.mancala.backend;

/**
 * Created by cdsain on 3/2/2017.
 */
public class Location {
    int numberOfStones;
    Location nextLocation;
    boolean isPlayable;
    Player player;

    public Location () {}

    public Location (int NumberOfStones, int fieldsLeftToMake, Location firstField, Player player) {
        this.player = player;
        if (fieldsLeftToMake > 7) {

            this.nextLocation = new Field(numberOfStones, fieldsLeftToMake-1, firstField, player);
        }
        else if (fieldsLeftToMake == 7) {

            this.nextLocation = new Kalaha(numberOfStones, fieldsLeftToMake-1, firstField, player);
        }
        else if (fieldsLeftToMake == 6) {

            this.nextLocation = new Field(numberOfStones, fieldsLeftToMake-1, firstField, player.getOpponent());
        }
        else if (fieldsLeftToMake > 0) {

            this.nextLocation = new Field(numberOfStones, fieldsLeftToMake-1, firstField, player);
        }
        else if (fieldsLeftToMake == 0) {

            this.nextLocation = new Kalaha(numberOfStones, fieldsLeftToMake-1, firstField, player);
        }
        else {
            this.nextLocation = firstField;
        }
    }

    public void increase() {
        this.numberOfStones++;
    }

    public void continueMove(int numberOfMoves) {
        if (numberOfMoves > 0) {
            this.increase();
            numberOfMoves--;
            getNextLocation().continueMove(numberOfMoves);
        }
        else {
            this.getPlayer().changeTurn();
        }
    }

    public boolean isPlayable () {
        if (this.numberOfStones>0 && this.getPlayer().isTurn()) {
            return true;
        }
        else {
            return false;
        }
    }

    public Location getKalaha() {
        return this.getNextLocation().getKalaha();
    }

    public void add(int stolenStones) {
        numberOfStones = numberOfStones + stolenStones;
    }

    public int getStones() {
        return numberOfStones;
    }

    public Location getNextLocation() {
        return this.nextLocation;
    }
    
    public Location getLocationToPlay(int fieldNumber) {
    	if(fieldNumber == 0){
    		return this;
    	}
    	return this.getNextLocation().getLocationToPlay(fieldNumber-1);
    }

    public Player getPlayer() {
        return this.player;
    }

    public boolean isLastInMove(int numberOfMoves) {
        if (numberOfMoves == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public Location getOpposite() {
        return this.getNextLocation().getOpposite().getNextLocation();
    }
    
    public int getNumberOfStonesOfPlayer(){
    	return this.getStones() + this.getNextLocation().getNumberOfStonesOfPlayer();
    }
    
    public boolean checkIfPossibleMove(Location field) {
    	if (!this.getPlayer().isTurn()){
    		return true;
    	}
    	else if (field.getStones() != 0 && field instanceof Field) {
            return true;
        }
        else if(field instanceof Kalaha){
            return false;
        }
        else {
            return checkIfPossibleMove(field.getNextLocation());
        }
    }
}
