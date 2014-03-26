package model.pieces;


/** class representing the brigadier general piece **/
public class BrigadierGeneral extends Piece{
	
	public static final int rank = 6;
	public static final char name = '6';
	
	public BrigadierGeneral() {
		super(rank, name);
	}
//	
//	public List<Move> getValidMoves(){
//		String[] moves = {"e2", "e3"};
//		return moves;
//	}
//	
}