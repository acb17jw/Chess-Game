package assignment2018;

import assignment2018.codeprovided.*;

/**
 * Move.java
 * 
 * Concrete class to represent a move
 * 
 * @author Jakub Wielgorski
 *
 */
public class Move {

	private Piece piece;
	private int currentX;
	private int currentY;
	private int newX;
	private int newY;
	private boolean flag;

	public Move(Piece piece, int cX, int cY, int nX, int nY, boolean flag) {
		this.piece = piece;
		currentX = cX;
		currentY = cY;
		newX = nX;
		newY = nY;
		this.flag = flag;

	}

	// accessors to co-ordinates
	public int getCurrentX() {
		return currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public int getNewX() {
		return newX;
	}

	public int getNewY() {
		return newY;
	}

	// gets piece
	public Piece getPiece() {
		return piece;
	}

	// overrides objects method
	public boolean equals(Move move) {
		if ((this.newX == move.getNewX()) && this.newY == move.getNewY()) {
			return true;
		}
		return false;
	}

}
