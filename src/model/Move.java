package model;

public class Move {

	private Space start;

	private Space end;

	public Move(int startRow, int startCol, int endRow, int endCol) {
		this.start = new Space(startRow, startCol);
		this.end = new Space(endRow, endCol);
	}

	public Move(Space start, Space end) {
		this.start = start;
		this.end = end;
	}

	public int getStartRow() {
		return start.getRow();
	}

	public int getStartCol() {
		return start.getCol();
	}

	public int getEndRow() {
		return end.getRow();
	}

	public int getEndCol() {
		return end.getCol();
	}

	public Space getStart() {
		return start;
	}

	public Space getEnd() {
		return end;
	}
}