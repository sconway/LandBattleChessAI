package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.Board;
import model.Move;
import model.Space;

import org.junit.Test;

public class BoardTests {

	Board board = new Board();
	
	@Test
	public void testOnBoard() {
		Space s1 = new Space(0, 0);
		Space s2 = new Space(9, 3);
		Space s3 = new Space(6, 2);
		Space s4 = new Space(-1, 3);
		Space s5 = new Space(3, 13);
		
		assertTrue(board.onBoard(s1));
		assertTrue(board.onBoard(s2));
		assertTrue(board.onBoard(s3));
		assertFalse(board.onBoard(s4));
		assertFalse(board.onBoard(s5));
	}
	
	@Test
	public void testCheckAdjacent() {
		Space s1 = new Space(2, 3);
		Space s2 = new Space(3, 4);
		Space s3 = new Space(2, 4);
		Space s4 = new Space(4, 3);
		Space s5 = new Space(3, 5);
		
		assertTrue(board.checkAdjacent(s1, s2));
		assertTrue(board.checkAdjacent(s1, s3));
		assertFalse(board.checkAdjacent(s1, s4));
		assertFalse(board.checkAdjacent(s1, s5));
		
	}
	 
	@Test
	public void checkOverFrontline() {
		Space s1 = new Space(5, 0);
		Space s2 = new Space(6, 0);
		Space s3 = new Space(8, 0);
		Space s4 = new Space(6, 1);
		Space s5 = new Space(5, 0);
		
		Space s6 = new Space(6, 2);
		Space s7 = new Space(5, 2);
		
		assertTrue(board.checkOverFrontline(s1, s2));
		assertFalse(board.checkOverFrontline(s1, s3));
		assertFalse(board.checkOverFrontline(s1, s4));
		assertFalse(board.checkOverFrontline(s1, s5));
		assertTrue(board.checkOverFrontline(s6, s7));
	}
	
	@Test
	public void testValidateMove() {
		Space s1 = new Space(5, 0);
		Space s2 = new Space(6, 0);
		Space s3 = new Space(5, 1);
		Space s4 = new Space(7, 1);
		Space s5 = new Space(1, 1);
		Space s6 = new Space(2, 1);
		Space s7 = new Space(1, 0);
		
		assertTrue(board.validateMove(new Move(s1, s2)));
		assertFalse(board.validateMove(new Move(s3, s4)));
		assertTrue(board.validateMove(new Move(s5, s6)));
		assertFalse(board.validateMove(new Move(s5, s7)));
	}
	
	@Test
	public void testCheckStraightLine() {
		Space s1 = new Space(5, 0);
		Space s2 = new Space(7, 0);
		Space s3 = new Space(6, 0);
		Space s4 = new Space(5, 1);
		Space s5 = new Space(7, 1);
		
		assertTrue(board.checkStraightLine(s1, s2));
		assertTrue(board.checkStraightLine(s1, s3));
		assertFalse(board.checkStraightLine(s1, s4));
		assertTrue(board.checkStraightLine(s4, s5));
	}
}
