package model.pieces;

/** class representing the lieutenant piece **/
public class Lieutenant extends Piece{
	
	public static final int rank = 2;
	public static final char name = '3';
	
	public Lieutenant() {
		super(rank, name);
	}
//
//	public String[] getValidMoves(){
//		String[] moves = {"e2", "e3"};
//		return moves;
//	}
//	
}