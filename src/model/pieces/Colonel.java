package model.pieces;


/** class representing the colonel piece **/
public class Colonel extends Piece{
	
	public static final int rank = 5;
	public static final char name = '5';
	
	public Colonel() {
		super(rank, name);
	}
//	
//	public List<Move> getValidMoves(){
//		String[] moves = {"e2", "e3"};
//		return moves;
//	}
//	
}