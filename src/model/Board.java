package model;

import java.util.ArrayList;
import java.util.List;

import model.pieces.Bomb;
import model.pieces.BrigadierGeneral;
import model.pieces.Captain;
import model.pieces.Colonel;
import model.pieces.Engineer;
import model.pieces.FieldMarshall;
import model.pieces.Flag;
import model.pieces.General;
import model.pieces.LandMine;
import model.pieces.Major;
import model.pieces.MajorGeneral;
import model.pieces.Opponent;
import model.pieces.Piece;
import model.pieces.PlatoonCommander;

/**
 * Creates a board
 * 
 * @author conways
 * 
 * 
 * 
 * METHODS:
 * 		getGameBoard()  							->     Piece[][]
 * 		getBoardConfiguration()  					->     char[][]
 * 		getPieceAt(int r, int c)   					->     Piece
 * 		getPieceAt(Space s)   						->     Piece
 * 		getOurPieces()     							->     ArrayList<Piece>
 *      getOppPieces()    							->     ArrayList<Piece>
 *      findPiece(Piece piece)     					->     Space
 *      checkAdjacent(Space s1, Space s2)     		->     boolean
 *      isSpaceOnBoard(Space space)     			->     boolean
 *      getSpaceType(Space space)     				->     char
 *      checkOverFrontline(Space s1, Space s2))     ->     boolean
 *      checkStraightLine(Space start, Space end)   ->     boolean
 *      
 *      
 *      
 * 		makeMove(Move move, Battle outcome)
 * 		removeFromGameBoard(Piece piece)
 *		removePiece(Piece piece)
 *		
 *		
 * 
 * 
 */
public class Board {
	
	public static int rows;
	public static int columns;

	// Initiated statically by the class loader
	private static Piece[][] gameBoard;

	// Keeps an updated list of all our active board pieces
	private static ArrayList<Piece> ourPieces = new ArrayList<Piece>();
	
	// Keeps an updated list of all opponent's active board pieces
	private static ArrayList<Piece> oppPieces = new ArrayList<Piece>();
	
	// P marks Front Line squares
	// M marks mountain border squares
	// R marks a rail road and a soldier station
	// S marks a soldier station
	// 
	private static final char[][] boardConfiguration = {
		{'S', 'H', 'S', 'H', 'S'},
		{'R', 'R', 'R', 'R', 'R'},
		{'R', 'C', 'S', 'C', 'R'},
		{'R', 'S', 'C', 'S', 'R'},
		{'R', 'C', 'S', 'C', 'R'},
		{'R', 'R', 'R', 'R', 'R'},
//		{'P', 'M', 'P', 'M', 'P'},
		{'R', 'R', 'R', 'R', 'R'},
		{'R', 'C', 'S', 'C', 'R'},
		{'R', 'S', 'C', 'S', 'R'},
		{'R', 'C', 'S', 'C', 'R'},
		{'R', 'R', 'R', 'R', 'R'},
		{'S', 'H', 'S', 'H', 'S'}};

	static {
		Bomb b1 = new Bomb();
		Bomb b2 = new Bomb();
		LandMine l1 = new LandMine();
		LandMine l2 = new LandMine();
		LandMine l3 = new LandMine();
		Flag f = new Flag();
		Engineer e1 = new Engineer();
		Engineer e2 = new Engineer();
		Engineer e3 = new Engineer();
		PlatoonCommander p1 = new PlatoonCommander();
		PlatoonCommander p2 = new PlatoonCommander();
		PlatoonCommander p3 = new PlatoonCommander();
		Captain c1 = new Captain();
		Captain c2 = new Captain();
		Captain c3 = new Captain();
		Major m1 = new Major();
		Major m2 = new Major();
		Colonel cl1 = new Colonel();
		Colonel cl2 = new Colonel();
		BrigadierGeneral bg1 = new BrigadierGeneral();
		BrigadierGeneral bg2 = new BrigadierGeneral();
		MajorGeneral mg1 = new MajorGeneral();
		MajorGeneral mg2 = new MajorGeneral();
		General g = new General();
		FieldMarshall fm = new FieldMarshall();
		
		ourPieces.add(0, b1);
		ourPieces.add(0, b2);
		ourPieces.add(0, l1);
		ourPieces.add(0, l2);
		ourPieces.add(0, l3);
		ourPieces.add(0, f);
		ourPieces.add(0, e1);
		ourPieces.add(0, e2);
		ourPieces.add(0, e2);
		ourPieces.add(0, p1);
		ourPieces.add(0, p2);
		ourPieces.add(0, p3);
		ourPieces.add(0, c1);
		ourPieces.add(0, c2);
		ourPieces.add(0, c3);
		ourPieces.add(0, m1);
		ourPieces.add(0, m2);
		ourPieces.add(0, cl1);
		ourPieces.add(0, cl2);
		ourPieces.add(0, bg1);
		ourPieces.add(0, bg2);
		ourPieces.add(0, mg1);
		ourPieces.add(0, mg2);
		ourPieces.add(0, g);
		ourPieces.add(0, fm);
		
		Opponent o1 = new Opponent();
		Opponent o2 = new Opponent();
		Opponent o3 = new Opponent();
		Opponent o4 = new Opponent();
		Opponent o5 = new Opponent();
		Opponent o6 = new Opponent();
		Opponent o7 = new Opponent();
		Opponent o8 = new Opponent();
		Opponent o9 = new Opponent();
		Opponent o10 = new Opponent();
		Opponent o11 = new Opponent();
		Opponent o12 = new Opponent();
		Opponent o13 = new Opponent();
		Opponent o14 = new Opponent();
		Opponent o15 = new Opponent();
		Opponent o16 = new Opponent();
		Opponent o17 = new Opponent();
		Opponent o18 = new Opponent();
		Opponent o19 = new Opponent();
		Opponent o20 = new Opponent();
		Opponent o21 = new Opponent();
		Opponent o22 = new Opponent();
		Opponent o23 = new Opponent();
		Opponent o24 = new Opponent();
		Opponent o25 = new Opponent();
		
		 oppPieces.add(o1);
		 oppPieces.add(o2);
		 oppPieces.add(o3);
		 oppPieces.add(o4);
		 oppPieces.add(o5);
		 oppPieces.add(o6);
		 oppPieces.add(o7);
		 oppPieces.add(o8);
		 oppPieces.add(o9);
		 oppPieces.add(o10);
		 oppPieces.add(o11);
		 oppPieces.add(o12);
		 oppPieces.add(o13);
		 oppPieces.add(o14);
		 oppPieces.add(o15);
		 oppPieces.add(o16);
		 oppPieces.add(o17);
		 oppPieces.add(o18);
		 oppPieces.add(o19);
		 oppPieces.add(o20);
		 oppPieces.add(o21);
		 oppPieces.add(o22);
		 oppPieces.add(o23);
		 oppPieces.add(o24);
		 oppPieces.add(o25);
		
		gameBoard = new Piece[][]{ 
				{b1,	f, 		l1, 	l2, 	l3},
				{p1, 	e1, 	b2, 	e2, 	e3},
				{c1, 	null, 	p2, 	null, 	p3},
				{m2, 	m1, 	null, 	c2, 	c3},
				{bg1, 	null, 	cl1, 	null, 	cl2},
				{fm, 	g, 		mg2, 	mg1, 	bg2},
//				{null, 	null, 	null, 	null, 	null},
				{o1, 	o2, 	o3, 	o4, 	o5},
				{o6, 	null, 	o7, 	null, 	o8},
				{o9, 	o10, 	null, 	o11, 	o12},
				{o13, 	null, 	o14, 	null, 	o15},
				{o16, 	o17, 	o18, 	o19, 	o20},
				{o21, 	o22, 	o23, 	o24, 	o25}};
		
		rows = gameBoard.length;
		columns = gameBoard[0].length;
	}
	
	/**
	 * Get the initial configuration of the board
	 */
	public static Piece[][] getGameBoard() {
		return gameBoard; 
	}
	
	/**
	 * Get board configuration
	 */
	public char[][] getBoardConfiguration() {
		return boardConfiguration;
	}
	
	/**
	 * Changes the game board to reflect the given move and outcome.
	 * @param move The move that was made
	 * @param outcome The outcome (in our terms) of the move
	 */
	public void makeMove(Move move, Battle outcome) {
		Piece startPiece = getPieceAt(move.getStart());
		Piece endPiece = getPieceAt(move.getEnd());
		
		switch(outcome){
		case LOSS:
			removePiece(startPiece);
		case TIE:
			removePiece(startPiece);
			removePiece(endPiece);
		case WIN:
			gameBoard[move.getEndRow()][move.getEndCol()] = startPiece; 
			gameBoard[move.getStartRow()][move.getStartCol()] = null;
			if(endPiece != null){
				removePiece(endPiece);
			}
		case MOVE:
			gameBoard[move.getEndRow()][move.getEndCol()] = startPiece;
			gameBoard[move.getStartRow()][move.getStartCol()] = null;
		default:
		}
	}
	
	/**
	 * Searches the game board array for the piece, and then sets that position to null;
	 * @param piece The piece to be removed
	 */
	private void removeFromGameBoard(Piece piece) {
		for(int i = 0; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[0].length; j++) {
				if(piece.equals(gameBoard[i][j])){
					gameBoard[i][j] = null;
				}
			}
		}
	}
	
	/**
	 * Remove the piece from the game board and pieces array;
	 * @param piece
	 */
	public void removePiece(Piece piece) {
		ourPieces.remove(piece);
		oppPieces.remove(piece);
		
		removeFromGameBoard(piece);
	}
	
	/**
	 * Get the piece at a specific location on the game board.
	 * @param r row
	 * @param c column
	 * @return The piece located at that position, or null if there is none.
	 */
	public Piece getPieceAt(int r, int c) {
		return gameBoard[r][c];
	}
	
	/**
	 * Get the piece at a specific location on the game board.
	 * @param s space
	 * @return The piece located at that position, or null if there is none.
	 */
	public Piece getPieceAt(Space s) {
		return gameBoard[s.getRow()][s.getCol()];
	}
	
	/**
	 * Returns a collection of all of our active game pieces
	 * @return our active pieces
	 */
	public List<Piece> getOurPieces(){
		return ourPieces;
	}
	
	/**
	 * Returns a collection of all of our opponent's active game pieces
	 * @return our opponent's active pieces
	 */
	public List<Piece> getOppPieces(){
		return oppPieces;
	}
	
	/**
	 * Returns a space representing the location of that piece
	 * @param piece a Piece
	 * @return a Space representing that piece's location, or null if it's not on the board
	 */
	public Space findPiece(Piece piece) {
		for(int i = 0; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[0].length; j++) {
				if(gameBoard[i][j] != null && piece.equals(gameBoard[i][j])){
					return new Space(i, j);
				}
			}
		}
		return null;
	}
	
	/**
	 * Checks if two Spaces are adjacent or the same space.
	 * @param s1 a space
	 * @param s2 another space
	 * @return true if the two spaces are adjacent or the same, false otherwise
	 */
	public boolean checkAdjacent(Space s1, Space s2) {
		if((s1.getRow() == 5 && s2.getRow() == 6) || 
		   (s1.getRow() == 6 && s2.getRow() == 5)) {
			return (s1.getCol() == s2.getCol() && s1.getCol() %2 == 0);
		}
		
		return Math.abs(s1.getRow() - s2.getRow()) <= 1 && 
			   Math.abs(s1.getCol() - s2.getCol()) <= 1;
	}
	
	/**
	 * Return a char representing the type of space
	 * @param space the Space to look at
	 * @return a char representing the type of space
	 */
	public char getSpaceType(Space space) {
		return boardConfiguration[space.getRow()][space.getCol()];
	}
	
	/**
	 * Determines if a space is actually on the board
	 * @param space a space
	 * @return true if the space is a valid game board space
	 */
	public boolean isSpaceOnBoard(Space space) {
		return (0 <= space.getRow()) && (space.getRow() < gameBoard.length) && 
			   (0 <= space.getCol()) && (space.getCol() < gameBoard[0].length);
	}
	
	
	/**
	 * Checks if two spaces straddle a frontline
	 * @param s1 a space
	 * @param s2 another space
	 * @return true if the spaces are on either side of a frontline
	 */
	public boolean checkOverFrontline(Space s1, Space s2) {
		return s1.getCol() == s2.getCol() && 
			   ((s1.getRow() == 5 && s2.getRow() == 6) || 
			    (s1.getRow() == 6 && s2.getRow() == 5)) && 
			   s1.getCol() %2 == 0;
	}
	
	
	/**
	 * Checks if two spaces are linked via a straight line
	 * @param s1 a space
	 * @param s2 another space
	 * @return true if the spaces are on the same line (linked via the railroad)
	 */
	public boolean checkStraightLine(Space start, Space end) {
		// Do the two spaces exist in the same row?
		if(start.getRow() == end.getRow()) {
			int row = start.getRow();
			// Do the two spaces exist in the same column? 
			if(start.getCol() > end.getCol()) {
				for(int i = start.getCol() - 1; i >= end.getCol(); i--) {
					if((getPieceAt(row, i) != null) || 
						getSpaceType(new Space(row, i)) != 'R') {
						return false;
					}
				}
			}
			else if(start.getCol() < end.getCol()) {
				for(int i = start.getCol() + 1; i <= end.getCol(); i++) {
					if((getPieceAt(row, i) != null) || 
						getSpaceType(new Space(row, i)) != 'R') {
						return false;
					}
				}
			}
			
			return true;
		}
		else if(start.getCol() == end.getCol()) {
			int col = start.getCol();
			if(start.getRow() > end.getRow()) {
				for(int i = start.getRow() - 1; i >= end.getRow(); i--) {
					if((getPieceAt(i, col) != null) || 
					   (getSpaceType(new Space(i, col)) != 'R' && 
					    getSpaceType(new Space(i, col)) == 'P')) {
						return false;
					}
				}
			}
			else if(start.getRow() < end.getRow()) {
				for(int i = start.getRow() + 1; i <= end.getRow(); i++) {
					if((getPieceAt(i, col) != null) || 
					   (getSpaceType(new Space(i, col)) != 'R' && 
					    getSpaceType(new Space(i, col)) == 'P')) {
						return false;
					}
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Checks if a specified move is valid according to the game rules
	 * @param move is a Move
	 * @return true if the passed move is valid
	 */
	public boolean validateMove(Move move) {
		Space start = move.getStart();
		Space end = move.getEnd();
		Piece piece = getPieceAt(move.getStart());
		
		if(piece instanceof Flag || piece instanceof LandMine) {
			return false;
		}
		
		if(start.equals(end) || !onBoard(end) || !ourPieces.contains(piece)) {
			return false;
		}
		
		switch(getSpaceType(start)){
			case 'S':
				return checkAdjacent(start, end)
						&& !ourPieces.contains(getPieceAt(end))
						&& (getSpaceType(end) != 'C' ||
							getPieceAt(end) == null)
						&& getSpaceType(end) != 'M';
			case 'H':
				return checkAdjacent(start, end)
						&& !ourPieces.contains(getPieceAt(end));
			case 'R':
				return (checkAdjacent(start, end))// || checkOverFrontline(start, end)) // || checkStraightLine(start, end))
						&& !ourPieces.contains(getPieceAt(end))
						&& (getSpaceType(end) != 'C' ||
							getPieceAt(end) == null)
						&& getSpaceType(end) != 'M';
			case 'C':
				return checkAdjacent(start, end)
						&& !ourPieces.contains(getPieceAt(end));
			default:
				return false;
		}
	}
	
	public void advanceBrigGen(){
		
		
	}
}
