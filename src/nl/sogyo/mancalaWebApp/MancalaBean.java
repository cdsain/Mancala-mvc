package nl.sogyo.mancalaWebApp;
import nl.sogyo.mancala.backend.*;
import java.util.*;

public class MancalaBean {
	
	private int turn = 0;
	private Mancala mancala = new Mancala();
	private ArrayList<Integer> stones = mancala.getStonesAtBoard();
	private String winner = mancala.getWinner();
	
	public MancalaBean() {
		
	}
	
	public MancalaBean(Mancala mancala) {
		this.mancala=mancala;
	}
	
	public MancalaBean(int turn, ArrayList<Integer> stones, Mancala mancala, String winner){
		this.turn = turn;
		this.stones = stones;
		this.mancala = mancala;
		this.winner = winner;
	}
	
	public ArrayList<Integer> getStones(){
		return this.stones;
	}
	
	public int getTurn(){
		return this.turn;
	}
	
	public Mancala getMancala(){
		return this.mancala;
	}
	
	public String getWinner() {
		return this.winner;
	}
	
}
