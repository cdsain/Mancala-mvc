package nl.sogyo.mancala.backend;

import java.util.ArrayList;

public class Mancala
{
	private Field field;
    
    public Mancala() {
    	this(4);
    }
    
    public Mancala(int stones) {
    	this.field = new Field(stones);
    }
    
    public Field getField() {
    	return this.field;
    }
    
    public void doMove(int fieldToPlay){
    	Location playField = this.field.getLocationToPlay((fieldToPlay-1) + (this.getPlayersTurn()*7));
    	((Field)playField).doMove();
    }
    
    public ArrayList<Integer> getStonesAtBoard(){
		ArrayList<Integer>stones = new ArrayList<Integer>();
		stones.add(this.field.getStones());
		Location next = this.field.getNextLocation();
		while(next != this.field){
			stones.add(next.getStones());
			next = next.getNextLocation();
		}
		return stones;
	}
    
    public int getPlayersTurn(){
    	if(this.field.getPlayer().isTurn == true){
    		return 0;
    	}
    	return 1;
    }
    
    public String getWinner(){
    	if(this.getPlayersTurn()==0 && this.getField().getPlayer().getWinner() == Winner.Self) {
    		return WinnerPlayer.Player1.toString();
    	}
    	else if(this.getPlayersTurn()==0 && this.getField().getPlayer().getWinner() == Winner.Other) {
    		return WinnerPlayer.Player2.toString();
    	}
    	else if(this.getPlayersTurn()==1 && this.getField().getPlayer().getWinner() == Winner.Self){
    		return WinnerPlayer.Player2.toString();
    	}
    	else if(this.getPlayersTurn()==1 && this.getField().getPlayer().getWinner() == Winner.Other){
    		return WinnerPlayer.Player1.toString();
    	}
    	else {
    		return this.getField().getPlayer().getWinner().toString();
    	}
    }
    
 
}
