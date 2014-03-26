package model.pieces;


public abstract class Piece{
	
	int rank;
	char name;
	
	public Piece(int rank, char name){
		this.rank = rank;
		this.name = name;
	}
	
	public char getName() {
		return name;
	}
	
	public int getRank() {
		return rank;
	}
//	
//	public abstract List<Move> getValidMoves();
//	
}