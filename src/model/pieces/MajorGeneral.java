package model.pieces;

/** class representing the major general piece **/
public class MajorGeneral extends Piece{
	
	public static final int rank = 7;
	public static final char name = '7';
	
	public MajorGeneral() {
		super(rank, name);
	}
//
//	public String[] getValidMoves(){
//		String[] moves = {"e2", "e3"};
//		return moves;
//	}
//	
}