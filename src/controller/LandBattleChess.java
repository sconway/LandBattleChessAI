package controller;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Battle;
import model.Board;
import model.Move;
import model.Space;
import model.pieces.Piece;

import communications.Messaging;

public class LandBattleChess {

	private static final String[] TIME_TAGS = new String[] { "--time/move"};
	private static final String[] GO_TAGS = new String[] { "--go" };
	private static final Pattern MS_FORMAT = Pattern.compile("[0-9]+(\\.[0-9])?ms");
	private static final Pattern S_FORMAT = Pattern.compile("[0-9]+(\\.[0-9])?s");
	
	// Sends/receives messages from the referee
	private Messaging messenger;
	
	// Represents the state of the board
	private Board board;
	
	private int turn;
	
	public LandBattleChess(int turn, int milliseconds) {
		messenger = new Messaging(this);
		board = new Board();
		this.turn = turn;

		messenger.readMessage();
		messenger.postInitialConfig(board.getGameBoard());

		if(turn == 1){
			Move m = findValidMove();
			messenger.postMove(m);
		}
	}
	
	/**
	 * A move was received from the referee
	 * @param move - the previous and destination of the piece
	 * @param player - the player that moved
	 * @param outcome - the result of the move
	 */
	public void moveMade(Move move, int player, Battle outcome) {
		if(player == this.turn) {
			weMoved(move, outcome);
		} else {		
			opponentMoved(move, outcome);
		}
	}
	
	/**
	 * Update the board based on an opponent's move
	 * @param move - the previous and destination of opponent's piece
	 * @param outcome - the outcome of the move
	 */
	public void opponentMoved(Move move, Battle outcome) {
		board.makeMove(move, outcome);
		Move nextMove = findValidMove();
		messenger.postMove(nextMove);
	}
	
	/**
	 * Update the board based on the our move
	 * @param move - the previous and destination of our piece
	 * @param outcome - the outcome of the move
	 */
	public void weMoved(Move move, Battle outcome) {
		board.makeMove(move, outcome);
	}
	
	/**
	 * Iterate through board and find an arbitrary move
	 * @return a valid move
	 */
	public Move findValidMove() {
		for(Piece piece : board.getOurPieces()) {
			Space space = board.findPiece(piece);
			for(int i = Board.rows - 1; i >= 0; i--) {
				for(int j = Board.columns - 1; j >= 0; j--) {
					Move move = new Move(space.getRow(), space.getCol(), i, j);
					if(board.validateMove(move)) {
						return move;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Parses the command line arguments, then initializes the LandBattleChess
	 * object to begin the game.
	 * @param args command line arguments supplied by the referee.
	 */
	public static void main(String[] args) {
		if(!validateArguments(args)) {
			System.exit(1);
		}
		
		int turnOrder = Integer.parseInt(args[1]);
		int time = getMilliseconds(args[3]);
		
		LandBattleChess game = new LandBattleChess(turnOrder, time);
	}

	/**
	 * 
	 * Returns the number of milliseconds a string represents.
	 * @param string of the format: "2s" | "2.5s" | "2000ms" | "2000.0ms"
	 * @return The number of milliseconds the string represents.
	 */
	private static int getMilliseconds(String string) {
		Matcher msMatcher = MS_FORMAT.matcher(string);
		Double dbl;
		
		if(msMatcher.matches()) {
			dbl = Double.parseDouble(string.replaceFirst("ms", ""));
		}
		else {
			dbl = 1000 * Double.parseDouble(string.replaceFirst("s", ""));
		}
		
		return dbl.intValue();
	}
	
	/**
	 * Determines whether the command line arguments are valid. Prints a
	 * message to Standard Error if an argument is invalid.
	 * @param args String array representing the command-line arguments passed 
	 * to this program.
	 * @return True if the arguments are valid, False otherwise.
	 */
	private static boolean validateArguments(String[] args) {
		if(args.length != 4) {
			System.err.println("Incorrect number of arguments.");
			return false;
		}
				
		if(!Arrays.asList(GO_TAGS).contains(args[0])) {
			System.err.println("Invalid argument. First argument must be one of: " + Arrays.toString(GO_TAGS));
			return false;
		}
		
		if(!args[1].equals("1") && !args[1].equals("2")) {
			System.err.println("Invalid argument. Second argument must be \"1\" or \"2\"");
			return false;
		}
		
		if(!Arrays.asList(TIME_TAGS).contains(args[2])) {
			System.err.println("Invalid argument. Third argument must be one of: " + Arrays.toString(TIME_TAGS));
			return false;
		}
		
		Matcher msMatcher = MS_FORMAT.matcher(args[3]);
		Matcher sMatcher = S_FORMAT.matcher(args[3]);
		
		if(!msMatcher.matches() && !sMatcher.matches()) {
			System.err.println("Invalid argument. Fourth argument must be one of the following formats: 2s, 2.0s, 2000ms, 2000.0ms");
			return false;
		}
		
		return true;
	}
}
