package assignment2018;

import java.util.*;
import assignment2018.codeprovided.*;

/**
 * Knight.java
 *
 * Concrete class to represent a knight
 *
 * @author Jakub Wielgorski
 * 
 */
public class Knight extends Piece {

	public Knight(int ix, int iy, int c, Board b) {
		super(PieceCode.KNIGHT, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	@Override
	public ArrayList<Move> availableMoves() {
		int x = this.getX();
		int y = this.getY();

		ArrayList<Move> knightMoves = new ArrayList<Move>();

		Move theMove = null;
		// represents knight move (up, right)
		if (!getBoard().outOfRange(x + 1, y - 2)) {

			boolean flag = getBoard().occupied(x + 1, y - 2);

			if ((flag && (getBoard().getPiece(x + 1, y - 2).getColour() != this.getColour())) || !flag) {

				theMove = new Move(this, x, y, x + 1, y - 2, flag);
				knightMoves.add(theMove);
			}
		}
		// represents knight move (up, left)
		if (!getBoard().outOfRange(x - 1, y - 2)) {

			boolean flag = getBoard().occupied(x - 1, y - 2);

			if ((flag && (getBoard().getPiece(x - 1, y - 2).getColour() != this.getColour())) || !flag) {

				theMove = new Move(this, x, y, x - 1, y - 2, flag);
				knightMoves.add(theMove);
			}
		}
		// represents knight move (down, right)
		if (!getBoard().outOfRange(x + 1, y + 2)) {

			boolean flag = getBoard().occupied(x + 1, y + 2);

			if ((flag && (getBoard().getPiece(x + 1, y + 2).getColour() != this.getColour())) || !flag) {

				theMove = new Move(this, x, y, x + 1, y + 2, flag);
				knightMoves.add(theMove);
			}
		}
		// represents knight move (down, left)
		if (!getBoard().outOfRange(x - 1, y + 2)) {

			boolean flag = getBoard().occupied(x - 1, y + 2);

			if ((flag && (getBoard().getPiece(x - 1, y + 2).getColour() != this.getColour())) || !flag) {

				theMove = new Move(this, x, y, x - 1, y + 2, flag);
				knightMoves.add(theMove);
			}
		}
		// represents knight move (left, up)
		if (!getBoard().outOfRange(x - 2, y - 1)) {

			boolean flag = getBoard().occupied(x - 2, y - 1);

			if ((flag && (getBoard().getPiece(x - 2, y - 1).getColour() != this.getColour())) || !flag) {

				theMove = new Move(this, x, y, x - 2, y - 1, flag);
				knightMoves.add(theMove);
			}
		}
		// represents knight move (left, down)
		if (!getBoard().outOfRange(x - 2, y + 1)) {

			boolean flag = getBoard().occupied(x - 2, y + 1);

			if ((flag && (getBoard().getPiece(x - 2, y + 1).getColour() != this.getColour())) || !flag) {

				theMove = new Move(this, x, y, x - 2, y + 1, flag);
				knightMoves.add(theMove);
			}
		}
		// represents knight move (right, up)
		if (!getBoard().outOfRange(x + 2, y - 1)) {

			boolean flag = getBoard().occupied(x + 2, y - 1);

			if ((flag && (getBoard().getPiece(x + 2, y - 1).getColour() != this.getColour())) || !flag) {

				theMove = new Move(this, x, y, x + 2, y - 1, flag);
				knightMoves.add(theMove);
			}
		}
		// represents knight move (right, down)
		if (!getBoard().outOfRange(x + 2, y + 1)) {

			boolean flag = getBoard().occupied(x + 2, y + 1);

			if ((flag && (getBoard().getPiece(x + 2, y + 1).getColour() != this.getColour())) || !flag) {

				theMove = new Move(this, x, y, x + 2, y + 1, flag);
				knightMoves.add(theMove);
			}
		}
		// returns null if there are not available moves for knight
		if (knightMoves.isEmpty())
			return null;
		return knightMoves;
	}

}
