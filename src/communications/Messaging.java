package communications;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import util.LBCUtils;
import model.Battle;
import model.Move;
import model.Space;
import model.pieces.Piece;
import controller.LandBattleChess;

/**
 * Messaging class
 * - Writes and reads messages using standard output/input
 * 
 * @author Sahil Singhal
 * @since March 13th, 2014
 */
public class Messaging {
	private BufferedWriter writer;
	private BufferedReader reader;
	private LandBattleChess main;
	
	public Messaging(LandBattleChess landBattleChess) {
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
		reader = new BufferedReader(new InputStreamReader(System.in));
		main = landBattleChess;
	}
	
	/**
	 * Write message to standard output
	 * @param s - string to write to standard output
	 */
	public void writeMessage(String s) {
		try {
			writer.write(s);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Read message from standard input
	 * @return the message
	 */
	public void readMessage() {
		Thread readerThread = new Thread(new Runnable() {
			public void run() {
				String input = "";
				String[] tokenizedMessage = null;
				try {
					while(true){
						input = reader.readLine();
						tokenizedMessage = input.split("\\s+");
						messageRouter(tokenizedMessage);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		readerThread.start();
	}
	
	/**
	 * Route messages to proper functions
	 * @param tokenizedMessage - array of strings 
	 */
	private void messageRouter(String[] tokenizedMessage) {
		int messageLength = tokenizedMessage.length;
		
		if(messageLength == 2) { 
			// Flag revealed message
			if(tokenizedMessage[0].equals(Messages.FLAG_POSITION)) {
				//TODO: main.flagRevealed(pos);
			// Victory message
			} else if (tokenizedMessage[1].equals(Messages.VICTORY)) {
				System.exit(0);
			}
		} else if (messageLength == 3) { 
			// Invalid board configuration
			if(tokenizedMessage[0].equals(Messages.INVALID)) {
				System.err.println("Invalid board setup");
				System.exit(1);
			}
		} else if (messageLength == 4) { 
			// Reading a move message
			String prev = tokenizedMessage[0];
			String dest = tokenizedMessage[1];
			int turn = Integer.parseInt(tokenizedMessage[2]);
			String moveType = tokenizedMessage[3];
			
			Space start = messageToSpace(prev);
			Space end = messageToSpace(dest);
			
			if(!(Battle.valueOf(moveType.toUpperCase()) == Battle.FLAG)){
				main.moveMade(new Move(new Space(start.getRow() - 1, start.getCol()), 
						new Space(end.getRow() - 1, end.getCol())), 
					turn, 
					Battle.valueOf(moveType.toUpperCase()));
			}
			
		} else { 
			// Invalid board move posted
			System.err.println("Invalid board move");
			System.exit(1);
		}
	}
	
	/**
	 * Converts a message of the form "A4" to a Space object
	 * @param position a position message
	 * @return a Space representing that position
	 */
	private Space messageToSpace(String position) {
		try {
			char colChar = position.charAt(0);
			int row = Integer.parseInt(position.substring(1));
			return new Space(row, LBCUtils.getColumnNum(colChar));
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/** 
	 * Post the initial configuration based on the two-dimensional array 
	 * @param board - two-dimensional array that will be parsed into message syntax
	 **/
	public void postInitialConfig(Piece[][] board) {
		String message = "(";
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < board[i].length; j++) {
				String position = "" + LBCUtils.rowPositions[j] + (i+1);
				if (board[i][j] != null) {
					char piece = board[i][j].getName();
					message += "(" + position + " " + piece + ")";
				}
			}
		}
		message += ")"; 
		writeMessage(message);
	}
	
	/**
	 * Post new move based on parameters
	 * @param start - position occupied by the piece
	 * @param end - the new position the piece should occupy
	 */
	public void postMove(String start, String end) {
		writeMessage("(" + start + " " + end + ")");
	}
	
	/**
	 * Post new move based on parameters
	 * @param move the move to be posted
	 */
	public void postMove(Move move) {
		String start = LBCUtils.rowPositions[move.getStartCol()] + "" + (move.getStartRow()+1);
		String end = LBCUtils.rowPositions[move.getEndCol()] + "" + (move.getEndRow()+1);
		writeMessage("(" + start + " " + end + ")");
	}

}