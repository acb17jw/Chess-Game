package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.*;

/**
 * Bishop.java
 *
 * Concrete class to represent a bishop 
 *
 * @author Jakub Wielgorski
 */
public class Bishop extends Piece {

	public Bishop(int ix, int iy, int c, Board b) {
		super(PieceCode.BISHOP, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	@Override
	public ArrayList<Move> availableMoves() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();
		// obtain new co-ordinates
		int newX = x;
		int newY = y;
		ArrayList<Move> bishopMoves = new ArrayList<Move>();

		Move theMove = null;
		// represents diagonal move (down, left)
		while (!getBoard().outOfRange(newX - 1, newY + 1)) {
			newX -= 1;
			newY += 1;

			if (!getBoard().occupied(newX, newY)) {
				theMove = new Move(this, x, y, newX, newY, false);
				bishopMoves.add(theMove);
			} else if (getBoard().occupied(newX, newY)
					&& (getBoard().getPiece(newX, newY).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, newX, newY, true);
				bishopMoves.add(theMove);
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
				bishopMoves.add(theMove);
			} else if (getBoard().occupied(newX, newY)
					&& (getBoard().getPiece(newX, newY).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, newX, newY, true);
				bishopMoves.add(theMove);
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
				bishopMoves.add(theMove);
			} else if (getBoard().occupied(newX, newY)
					&& (getBoard().getPiece(newX, newY).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, newX, newY, true);
				bishopMoves.add(theMove);
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
				bishopMoves.add(theMove);
			} else if (getBoard().occupied(newX, newY)
					&& (getBoard().getPiece(newX, newY).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, newX, newY, true);
				bishopMoves.add(theMove);
				break;
			} else {
				break;
			}
		}

		newX = this.getX();
		newY = this.getY();

		// returns null if there are not available moves for bishop
		if (bishopMoves.isEmpty())
			return null;

		return bishopMoves;

	}

}
