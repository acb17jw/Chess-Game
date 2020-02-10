package assignment2018;

import assignment2018.codeprovided.*;

/**
 * TextDisplay.java
 * 
 * Concrete class to represent a text interface
 * 
 * @author Jakub Wielgorski
 *
 */
public class TextDisplay implements Display {

	private Board chessBoard;

	// constructor takes board
	public TextDisplay(Board b) {
		chessBoard = b;
	}

	@Override
	// method used to display each piece
	public void displayBoard(Pieces myPieces) {
		Piece cBoard[][] = new Piece[PieceCode.XSIZE][PieceCode.YSIZE];

		cBoard = chessBoard.getBoard();
		System.out.println("-A B C D E F G H");

		for (int i = 0; i < PieceCode.YSIZE; i++) {
			System.out.print(i + 1);

			for (int j = 0; j < PieceCode.XSIZE; j++) {

				if (cBoard[j][i] != null) {
					System.out.print(" " + cBoard[j][i]);
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}

	}

}
