package nl.sogyo.mancala.backend;

public class Field extends Location {

    public Field(int numberOfStones) {
        super.numberOfStones = numberOfStones;
        this.player = new Player();
        this.nextLocation = new Field(numberOfStones, 11, this, player);
    }

    public Field(int numberOfStones, int fieldsLeftToMake, Location firstField, Player player) {
        super(numberOfStones, fieldsLeftToMake, firstField, player);
        this.numberOfStones = 4;
    }

    public void empty() {
        this.numberOfStones -= numberOfStones;
    }

    public void doMove() {
    	Location fieldOne = this.getKalaha().getNextLocation().getKalaha().getNextLocation();
    	if(this.checkIfPossibleMove(fieldOne)){
    		if (isPlayable()) {
    			int numberOfMoves = super.getStones();
    			empty();
    			getNextLocation().continueMove(numberOfMoves);
    		}
    	}
    	else {
    		determineWinner(fieldOne);
    	}
    }
    
    public void determineWinner(Location fieldOne){
    	int stonesPlayerOne = fieldOne.getNumberOfStonesOfPlayer();
    		int stonesPlayerTwo = fieldOne.getKalaha().getNextLocation().getNumberOfStonesOfPlayer();
    		if(stonesPlayerOne>stonesPlayerTwo){
    			this.getPlayer().setWinner(Winner.Self);
    		}
    		else if(stonesPlayerTwo>stonesPlayerOne){
    			this.getPlayer().setWinner(Winner.Other);
    		}
    		else {
    			this.getPlayer().setWinner(Winner.Draw);
    		} 
    }

    public void continueMove(int numberOfMoves) {
        if (numberOfMoves > 1) {
            super.continueMove(numberOfMoves);
        }
        else if (numberOfMoves == 1) {
            if (wasZero() && this.getPlayer().isTurn()) {
                this.increase();
                stealStones();
                this.player.changeTurn();
            }
            else {
                super.continueMove(numberOfMoves);
            }
        }
        else {
            super.continueMove(numberOfMoves);
        }
    }

    public boolean wasZero() {
        if (numberOfStones > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void stealStones() {
        int stonesStolen = this.getStones() + this.getOpposite().getStones();
        this.numberOfStones = 0;
        getOpposite().numberOfStones = 0;
        getKalaha().add(stonesStolen);
    }
    
    
}
