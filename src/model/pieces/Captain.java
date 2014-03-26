package model.pieces;


/** class representing the captain piece **/
public class Captain extends Piece{
	
	public static final int rank = 3;
	public static final char name = '3';
	
	public Captain() {
		super(rank, name);
	}
//	
//	public List<Move> getValidMoves(){
//		String[] moves = {"e2", "e3"};
//		return moves;
//	}
//	
}