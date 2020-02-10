package assignment2018;

import java.util.*;

import assignment2018.codeprovided.*;

/**
 * Chess.java Concrete class used to create the game
 * 
 * @author Jakub Wielgorski
 *
 */
public class Chess {
	public static void main(String[] args) {
		/*
		 * create new objects of: Board, TekstDisplay and GraphicalDisplay, Pieces and
		 * Players
		 */
		Board board = new Board();
		TextDisplay t = new TextDisplay(board);

		Pieces whitePieces = new Pieces(board, PieceCode.WHITE);
		Pieces blackPieces = new Pieces(board, PieceCode.BLACK);
		GraphicalDisplay blackGraphical = new GraphicalDisplay(board, whitePieces, blackPieces);

		Player blackPlayer = new HumanPlayer("humanPlayer", blackPieces, board, null);
		Player whitePlayer;

		t.displayBoard(whitePieces);
		blackGraphical.displayBoard(whitePieces);

		boolean kingIsDead = false; // variable for checking if the king is dead
		int blackListSize;
		int whiteListSize;
		int turn = PieceCode.WHITE;
		// input form user to set up the game
		Scanner keyboard = new Scanner(System.in);

		System.out.println("If you want to play by using buttons in graphical");
		System.out.println("display press 'g' else press random char");
		System.out.println("if you won't press 'g' you still will be able");
		System.out.println("to see graphical display but you won't be able to use buttons");

		String start = keyboard.nextLine();
		System.out.println("If you want to play against aggressive player press 'a'");
		System.out.println("if you want to play against random player press 'r'");
		System.out.println("if you want to play against human player press anything else");
		String opponent = keyboard.nextLine();

		char ch1 = start.charAt(0);
		char ch2 = opponent.charAt(0);
		switch (ch2) {
		case 'a':
			whitePlayer = new AggressivePlayer("computerPlayer", whitePieces, board, blackPlayer);
			break;
		case 'r':
			whitePlayer = new RandomPlayer("computerPlayer", whitePieces, board, blackPlayer);
			break;
		default:
			whitePlayer = new HumanPlayer("humanPlayer", whitePieces, board, blackPlayer);
		}
		blackPlayer.setOpponent(whitePlayer);
		// is used if user has chosen textDisplay
		if (ch1 != 'g') {
			// if king is dead game over
			while (!kingIsDead) {

				boolean whiteMove = whitePlayer.makeMove();
				// wait until white player makes legal move
				while (!whiteMove) {
					System.out.println("white make legal move!");
					whiteMove = whitePlayer.makeMove();
				}

				kingIsDead = true;
				// check if king is dead
				blackListSize = blackPieces.getNumPieces();
				for (int i = 0; i < blackListSize; i++) {
					if (blackPieces.getPiece(i).getValue() == PieceCode.KING) {

						kingIsDead = false;
					}
				}
				if (kingIsDead) {
					break;
				}
				t.displayBoard(whitePieces);
				blackGraphical.displayBoard(whitePieces);

				boolean blackMove = blackPlayer.makeMove();
				// wait until black player makes legal move
				while (!blackMove) {
					System.out.println("black make legal move!");
					blackMove = blackPlayer.makeMove();
				}
				kingIsDead = true;
				// check if king is dead
				whiteListSize = whitePieces.getNumPieces();
				for (int i = 0; i < whiteListSize; i++) {
					if (whitePieces.getPiece(i).getValue() == PieceCode.KING) {

						kingIsDead = false;
					}
				}

				t.displayBoard(blackPieces);
				blackGraphical.displayBoard(blackPieces);

			}
			// text is displayed after game is over
			System.out.println("game over!");

			// is used if user has chosen graphicalDisplay
		} else {
			// if king is dead game over
			while (!kingIsDead) {
				// checks whose turn is it
				if (turn == PieceCode.WHITE) {
					blackGraphical.displayBoard(whitePieces);
					boolean whiteMove = blackGraphical.isMoveMade();
					// wait until white player makes legal move
					while (!whiteMove) {
						if (whitePlayer.toString().equals("computerPlayer")) {
							whitePlayer.makeMove();
							break;

						}
						blackGraphical.displayBoard(whitePieces);
						whiteMove = blackGraphical.isMoveMade();

					}
					turn = PieceCode.BLACK;
				}

				kingIsDead = true;
				// check if king is dead
				blackListSize = blackPieces.getNumPieces();
				for (int i = 0; i < blackListSize; i++) {
					if (blackPieces.getPiece(i).getValue() == PieceCode.KING) {

						kingIsDead = false;
					}
				}
				if (kingIsDead) {
					break;
				}
				t.displayBoard(whitePieces);
				// checks whose turn is it
				if (turn == PieceCode.BLACK) {
					blackGraphical.displayBoard(blackPieces);

					boolean blackMove = blackGraphical.isMoveMade();
					// wait until black player makes legal move
					while (!blackMove) {
						if (blackPlayer.toString().equals("computerPlayer")) {
							blackPlayer.makeMove();
							break;
						}
						blackGraphical.displayBoard(blackPieces);
						blackMove = blackGraphical.isMoveMade();

					}
					turn = PieceCode.WHITE;
				}
				kingIsDead = true;
				// check if king is dead
				whiteListSize = whitePieces.getNumPieces();
				for (int i = 0; i < whiteListSize; i++) {
					if (whitePieces.getPiece(i).getValue() == PieceCode.KING) {

						kingIsDead = false;
					}
				}

			}
			t.displayBoard(blackPieces);
			blackGraphical.displayBoard(blackPieces);

			// text is displayed after game is over
			System.out.println("game over!");
		}

	}

}
