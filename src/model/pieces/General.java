package model.pieces;

/** class representing the general piece **/
public class General extends Piece{
	
	public static final int rank = 8;
	public static final char name = '8';
	
	public General() {
		super(rank, name);
	}
//
//	public String[] getValidMoves(){
//		String[] moves = {"e2", "e3"};
//		return moves;
//	}
//	
}