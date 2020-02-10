package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.*;;

/**
 * Queen.java
 *
 * Concrete class to represent a queen
 *
 * @author Jakub Wielgorski
 */
public class Queen extends Piece {

	public Queen(int ix, int iy, int c, Board b) {
		super(PieceCode.QUEEN, ix, iy, c, b);
	}

	@Override
	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		// obtain new co-ordinates
		int newX = x;
		int newY = y;

		ArrayList<Move> queenMoves = new ArrayList<Move>();

		Move theMove = null;

		// represents diagonal move (down, left)
		while (!getBoard().outOfRange(newX - 1, newY + 1)) {
			newX -= 1;
			newY += 1;

			if (!getBoard().occupied(newX, newY)) {
				theMove = new Move(this, x, y, newX, newY, false);
				queenMoves.add(theMove);
			} else if (getBoard().occupied(newX, newY)
					&& (getBoard().getPiece(newX, newY).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, newX, newY, true);
				queenMoves.add(theMove);
				break;
			} else {
				break;
			}
		}
		newX = this.getX();
		newY = this.getY();

		// represents diagonal move (down, right)
		while (!getBoard().outOfRange(newX + 1, newY + 1)) {
			newX += 1;
			newY += 1;

			if (!getBoard().occupied(newX, newY)) {
				theMove = new Move(this, x, y, newX, newY, false);
				queenMoves.add(theMove);
			} else if (getBoard().occupied(newX, newY)
					&& (getBoard().getPiece(newX, newY).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, newX, newY, true);
				queenMoves.add(theMove);
				break;
			} else {
				break;
			}
		}
		newX = this.getX();
		newY = this.getY();

		// represents diagonal move (up, left)
		while (!getBoard().outOfRange(newX - 1, newY - 1)) {
			newX -= 1;
			newY -= 1;

			if (!getBoard().occupied(newX, newY)) {
				theMove = new Move(this, x, y, newX, newY, false);
				queenMoves.add(theMove);
			} else if (getBoard().occupied(newX, newY)
					&& (getBoard().getPiece(newX, newY).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, newX, newY, true);
				queenMoves.add(theMove);
				break;
			} else {
				break;
			}
		}
		newX = this.getX();
		newY = this.getY();

		// represents diagonal move (up, right)
		while (!getBoard().outOfRange(newX + 1, newY - 1)) {
			newX += 1;
			newY -= 1;

			if (!getBoard().occupied(newX, newY)) {
				theMove = new Move(this, x, y, newX, newY, false);
				queenMoves.add(theMove);
			} else if (getBoard().occupied(newX, newY)
					&& (getBoard().getPiece(newX, newY).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, newX, newY, true);
				queenMoves.add(theMove);
				break;
			} else {
				break;
			}
		}
		newX = this.getX();
		newY = this.getY();

		// represent move left
		for (int i = x - 1; i >= 0; i--) {
			if (!getBoard().occupied(i, y)) {
				theMove = new Move(this, x, y, i, y, false);
				queenMoves.add(theMove);
			} else if (getBoard().occupied(i, y) && (getBoard().getPiece(i, y).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, i, y, true);
				queenMoves.add(theMove);
				break;
			} else {
				break;

			}
		}

		// represent move right
		for (int i = x + 1; i < PieceCode.XSIZE; i++) {
			if (!getBoard().occupied(i, y)) {
				theMove = new Move(this, x, y, i, y, false);
				queenMoves.add(theMove);
			} else if (getBoard().occupied(i, y) && (getBoard().getPiece(i, y).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, i, y, true);
				queenMoves.add(theMove);
				break;
			} else {
				break;
			}
		}

		// represent move up
		for (int i = y - 1; i >= 0; i--) {
			if (!getBoard().occupied(x, i)) {
				theMove = new Move(this, x, y, x, i, false);
				queenMoves.add(theMove);
			} else if (getBoard().occupied(x, i) && (getBoard().getPiece(x, i).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, x, i, true);
				queenMoves.add(theMove);
				break;
			} else {
				break;
			}
		}

		// represent move down
		for (int i = y + 1; i < PieceCode.YSIZE; i++) {
			if (!getBoard().occupied(x, i)) {
				theMove = new Move(this, x, y, x, i, false);
				queenMoves.add(theMove);
			} else if (getBoard().occupied(x, i) && (getBoard().getPiece(x, i).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, x, i, true);
				queenMoves.add(theMove);
				break;
			} else {
				break;
			}
		}

		// returns null if there are not available moves for queen
		if (queenMoves.isEmpty())
			return null;
		return queenMoves;

	}

}
