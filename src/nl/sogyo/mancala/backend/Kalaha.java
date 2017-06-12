package nl.sogyo.mancala.backend;

/**
 * Created by cdsain on 3/1/2017.
 */
public class Kalaha extends Location {

    boolean isPlayable;

    public Kalaha(int numberOfStones, int fieldsLeftToMake, Location firstField, Player player) {
        super(numberOfStones, fieldsLeftToMake, firstField, player);
        this.numberOfStones = 0;
    }

    public void add(int stolenStones) {
        this.numberOfStones = numberOfStones + stolenStones;
    }

    public void continueMove(int numberOfMoves) {
        if(this.player.isTurn()&& isLastInMove(numberOfMoves)) {
            this.increase();
            this.getPlayer().changeTurn();
            super.continueMove(--numberOfMoves);
        }
        else if (this.player.isTurn()) {
            super.continueMove(numberOfMoves);
        }
        else {
            getNextLocation().continueMove(numberOfMoves);
        }
    }

    public boolean isPlayable () {
        return isPlayable = false;
    }

    public Location getKalaha() {
        return this;
    }

    public Location getOpposite() {
        return this;
    }
    
    public int getNumberOfStonesOfPlayer(){
    	return this.getStones();
    }

}
