package util;

import java.util.ArrayList;
import java.util.List;

import model.Move;

public class LBCUtils {

	public static final List<Move> NO_MOVES = new ArrayList<Move>();
	public static final char[] rowPositions = {'A', 'B', 'C', 'D', 'E'};
	
	/**
	 * Gets the column number for a coordinate letter.
	 * @param letter The letter
	 * @return The column number for that letter
	 */
	public static int getColumnNum(char letter) {
		for(int i = 0; i < rowPositions.length; i++) {
			if(letter == rowPositions[i]) {
				return i;
			}
		}
		return -1;
	}
}
