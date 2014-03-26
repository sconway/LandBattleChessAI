package model;

public class Space {

	private int row;
	private int col;
	
	public Space(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Space) {
			Space otherSpace = (Space)other;
			return otherSpace.getRow() == getRow() 
					&& otherSpace.getCol() == getCol();
		}
		return false;
	}
	
}
