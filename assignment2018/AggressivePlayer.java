package assignment2018;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import assignment2018.codeprovided.*;

/**
 * AggressivePlayer.java
 * 
 * Inherits form RandomPlayer.java Class to represent AI as an agressivePlayer
 * 
 * @author Jakub Wielgorski
 *
 */
public class AggressivePlayer extends RandomPlayer {

	public AggressivePlayer(String n, Pieces p, Board b, Player o) {
		super(n, p, b, o);

	}

	// variable used to find the most aggressive move
	private int value = 0;
	Piece piece;
	Pieces alivePieces;
	Move move;

	/**
	 * 
	 * @return most aggressive move
	 */
	public Move getAgressiveMove() {
		move = null;
		alivePieces = this.getPieces();
		int numAlivePieces = alivePieces.getNumPieces();
		// Outer loop checks every available piece
		for (int i = 0; i < numAlivePieces; i++) {

			ArrayList<Move> listOfMoves = new ArrayList<Move>();
			listOfMoves = alivePieces.getPiece(i).availableMoves();

			if (listOfMoves != null) {

				// if the piece has available moves inner
				// loop looks for most aggressive one
				for (Move m : listOfMoves) {
					int nx = m.getNewX();
					int ny = m.getNewY();

					// flag checks if new position is occupied
					boolean flag = getBoard().occupied(nx, ny);
					if (flag) {
						int valueOfOpponentPiece = getBoard().getPiece(nx, ny).getValue();
						if (value < valueOfOpponentPiece) {
							int x = m.getCurrentX();
							int y = m.getCurrentY();
							// assign new move to beat piece with the highest value
							move = new Move(m.getPiece(), x, y, nx, ny, flag);
							value = valueOfOpponentPiece;
						}
					}
				}
			}
		}
		return move;
	}

	@Override
	// returns true if move was made
	public boolean makeMove() {
		Move agressiveMove = getAgressiveMove();
		// if aggressive move is not possible,
		// random move is made
		if (agressiveMove == null) {

			return super.makeMove();
			// if aggressive move is possible
			// aggressive move is made
		} else {
			int nx = agressiveMove.getNewX();
			int ny = agressiveMove.getNewY();
			int x = agressiveMove.getCurrentX();
			int y = agressiveMove.getCurrentY();
			piece = agressiveMove.getPiece();
			getOpponent().deletePiece(getBoard().getPiece(nx, ny));
			getBoard().setPosition(x, y, null);
			getBoard().setPosition(nx, ny, piece);
			piece.setPosition(nx, ny);

			return true;
		}

	}

}
