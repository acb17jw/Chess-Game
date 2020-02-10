package assignment2018;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import assignment2018.codeprovided.*;

/**
 * RandomPlayer.java
 * 
 * Inherits form Player.java Class to represent AI as an randomPlayer
 * 
 * @author Jakub Wielgorski
 *
 */
public class RandomPlayer extends Player {

	int randomNum;
	Pieces myPieces;
	Piece piece;

	public RandomPlayer(String n, Pieces p, Board b, Player o) {
		super(n, p, b, o);
	}

	// method returns random available piece
	public Piece randomPiece() {

		myPieces = this.getPieces();
		int numAlivePieces = myPieces.getNumPieces();
		randomNum = ThreadLocalRandom.current().nextInt(0, numAlivePieces);
		piece = myPieces.getPiece(randomNum);

		// if available moves of chosen piece are not exist
		// piece is chosen again
		while (piece.availableMoves() == null) {
			this.randomPiece();
		}
		return piece;
	}

	// method to generate random number
	public int randomNum(ArrayList<Move> list) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
		return randomNum;
	}

	@Override
	// returns true if move was made
	public boolean makeMove() {

		Piece randomPiece = this.randomPiece();
		ArrayList<Move> listOfMoves = randomPiece.availableMoves();

		// chose random move form available moves
		int randomIndexGenerator = randomNum(listOfMoves);

		Move randomMove = listOfMoves.get(randomIndexGenerator);

		int nx = randomMove.getNewX();
		int ny = randomMove.getNewY();
		int x = randomMove.getCurrentX();
		int y = randomMove.getCurrentY();

		// check if any of opponent's piece was attacked
		boolean flag = getBoard().occupied(nx, ny);
		if (flag) {
			getOpponent().deletePiece(getBoard().getPiece(nx, ny));
		}
		getBoard().setPosition(x, y, null);
		getBoard().setPosition(nx, ny, randomPiece);
		randomPiece.setPosition(nx, ny);
		return true;
	}
}