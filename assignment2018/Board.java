package assignment2018;

import assignment2018.codeprovided.*;

/**
 * Board.java
 * 
 * Concrete class to represent a board
 * 
 * @author acb17jw
 *
 */

public class Board {

	Piece chessBoard[][] = new Piece[PieceCode.XSIZE][PieceCode.YSIZE];

	// constructor creates empty board
	public Board() {
		for (int i = 0; i < PieceCode.XSIZE; i++) {
			for (int j = 0; j < PieceCode.YSIZE; j++) {
				chessBoard[i][j] = null;
			}
		}
	}

	// accessor returns board
	public Piece[][] getBoard() {
		return chessBoard;
	}

	// sets position of the piece in the board
	public void setPosition(int x, int y, Piece piece) {

		chessBoard[x][y] = piece;
	}

	// check if the coords are in the range of board
	public boolean outOfRange(int x, int y) {
		if (x > 7 || x < 0 || y > 7 || y < 0)
			return true;
		else
			return false;
	}

	// check if the tile is occupied
	public boolean occupied(int x, int y) {
		if (chessBoard[x][y] == null)
			return false;
		else
			return true;
	}

	// accesor returns piece
	public Piece getPiece(int x, int y) {
		return chessBoard[x][y];
	}

}
