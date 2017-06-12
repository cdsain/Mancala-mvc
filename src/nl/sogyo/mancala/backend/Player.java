package nl.sogyo.mancala.backend;

public class Player {

    private boolean ifPossibleMove = true;
    boolean isTurn = false;
    private Player opponent;
    private Winner winner;
  
    public Player() {
        this.opponent = new Player(this);
        this.isTurn = true;
        this.winner = Winner.No_Decision;
    }

    public Player(Player player) {
        this.opponent = player;
        this.isTurn = false;
        this.winner = Winner.No_Decision;
    }

    public void changeTurn() {
        this.setTurn();
        this.getOpponent().setTurn();
    }

    public void setTurn() {
        this.isTurn = !isTurn;
    }

    public Player getOpponent() {
        return opponent;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public boolean getIfPossibleMove() {
        return ifPossibleMove;
    }
    
    public Winner getWinner(){
    	return this.winner;
    }
    
    public void setWinner(Winner winner){
    	this.winner = winner;
    }
   
}
