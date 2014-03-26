package model.pieces;


/** class representing the field marshall piece **/
public class FieldMarshall extends Piece{
	
	public static final int rank = 9;
	public static final char name = '9';
	
	public FieldMarshall() {
		super(rank, name);
	}
//
//	public List<Move> getValidMoves(){
//		String[] moves = {"e2", "e3"};
//		return moves;
//	}
//	
}