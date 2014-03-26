package model.pieces;


/** class representing the engineer piece **/
public class Engineer extends Piece{
	
	public static final int rank = 1;
	public static final char name = '1';
	
	public Engineer() {
		super(rank, name);
	}
//
//	public List<Move> getValidMoves(){
//		String[] moves = {"e2", "e3"};
//		return moves;
//	}
//	
}