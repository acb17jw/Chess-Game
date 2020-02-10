package assignment2018;

import assignment2018.codeprovided.*;

import java.util.*;

/**
 * HumanPlayer.java
 * 
 * Concrete class to represent HumanPlayer Inherits form Player
 * 
 * @author Jakub Wielgórski
 *
 */
public class HumanPlayer extends Player {

	public HumanPlayer(String n, Pieces p, Board b, Player o) {
		super(n, p, b, o);
	}

	@Override
	// returns true if move was made
	public boolean makeMove() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("make a move");

		// waits for user's input to proceed
		String start = keyboard.nextLine();
		start = start.replaceAll("\\s+", "");
		if (start.length() != 4) {
			return false;
		}
		char ch1 = start.charAt(0);
		char ch2 = start.charAt(1);
		char ch3 = start.charAt(2);
		char ch4 = start.charAt(3);

		int x = ch1 - 'A';
		int y = -1;
		int nx = ch3 - 'A';
		int ny = -1;
		System.out.println(ch1 + " " + ch2 + " " + ch3 + " " + ch4);

		// Determines if the specified character is a digit.
		if ((Character.isDigit(ch2)) && (Character.isDigit(ch4))) {
			y = Character.getNumericValue(ch2) - 1;
			ny = Character.getNumericValue(ch4) - 1;
		}
		// check if input is out of bounds
		if ((x > 7) || (x < 0) || (y > 7) || (y < 0) || (nx > 7) || (nx < 0) || (ny > 7) || (ny < 0)) {
			System.out.println(x + " " + y + " " + nx + " " + ny);
			return false;
		}

		Piece piece = getBoard().getPiece(x, y);
		if (piece != null) {
			int pieceColour = piece.getColour();
			int playerColour = getPieces().getPiece(0).getColour();

			// checks if the colour of the piece is the same as colour of player
			if (pieceColour == playerColour) {

				boolean flag = getBoard().occupied(nx, ny);

				Move move = new Move(piece, x, y, nx, ny, flag);

				ArrayList<Move> listOfMoves = new ArrayList<Move>();

				listOfMoves = piece.availableMoves();

				// check if move is available
				for (Move m : listOfMoves) {

					if (m.equals(move)) {
						if (flag) {
							getOpponent().deletePiece(getBoard().getPiece(nx, ny));
						}
						getBoard().setPosition(x, y, null);
						getBoard().setPosition(nx, ny, piece);
						piece.setPosition(nx, ny);

						return true;

					}
				}

			}
		}
		return false;

	}

}
