package assignment2018;

import java.util.*;
import assignment2018.codeprovided.*;

/**
 * Rook.java
 *
 * Concrete class to represent a rook
 *
 * @author Jakub Wielgorski
 */
public class Rook extends Piece {

	public Rook(int ix, int iy, int c, Board b) {
		super(PieceCode.ROOK, ix, iy, c, b);
	}

	@Override
	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		ArrayList<Move> rookMoves = new ArrayList<Move>();

		// represent move left
		Move theMove = null;

		for (int i = x - 1; i >= 0; i--) {
			if (!getBoard().occupied(i, y)) {
				theMove = new Move(this, x, y, i, y, false);
				rookMoves.add(theMove);
			} else if (getBoard().occupied(i, y) && (getBoard().getPiece(i, y).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, i, y, true);
				rookMoves.add(theMove);
				break;
			} else {
				break;

			}
		}

		// represent move right
		for (int i = x + 1; i < PieceCode.XSIZE; i++) {
			if (!getBoard().occupied(i, y)) {
				theMove = new Move(this, x, y, i, y, false);
				rookMoves.add(theMove);
			} else if (getBoard().occupied(i, y) && (getBoard().getPiece(i, y).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, i, y, true);
				rookMoves.add(theMove);
				break;
			} else {
				break;
			}
		}

		// represent move up
		for (int i = y - 1; i >= 0; i--) {
			if (!getBoard().occupied(x, i)) {
				theMove = new Move(this, x, y, x, i, false);
				rookMoves.add(theMove);
			} else if (getBoard().occupied(x, i) && (getBoard().getPiece(x, i).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, x, i, true);
				rookMoves.add(theMove);
				break;
			} else {
				break;
			}
		}

		// represent move down
		for (int i = y + 1; i < PieceCode.YSIZE; i++) {
			if (!getBoard().occupied(x, i)) {
				theMove = new Move(this, x, y, x, i, false);
				rookMoves.add(theMove);
			} else if (getBoard().occupied(x, i) && (getBoard().getPiece(x, i).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, x, i, true);
				rookMoves.add(theMove);
				break;
			} else {
				break;
			}
		}
		// returns null if there are not available moves for rook
		if (rookMoves.isEmpty()) {
			return null;
		}
		return rookMoves;
	}

}
