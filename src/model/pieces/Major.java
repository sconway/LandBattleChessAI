package model.pieces;

/** class representing the major piece **/
public class Major extends Piece{
	
	public static final int rank = 4;
	public static final char name = '4';
	
	public Major() {
		super(rank, name);
	}
//
//	public String[] getValidMoves(){
//		String[] moves = {"e2", "e3"};
//		return moves;
//	}
//	
}