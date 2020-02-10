package assignment2018;

import assignment2018.codeprovided.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * GraphicalDisplay.java
 * 
 * Concrete class to represent a graphical interface
 * 
 * @author Jakub Wielgorski
 *
 */
public class GraphicalDisplay extends JFrame implements Display {

	private Board chessBoard;
	TextDisplay t;

	// array of buttons to control chess board
	private JButton[][] chessBoardSquares = new JButton[8][8];
	private Pieces pieces1;
	private Pieces pieces2;
	private Pieces opponentPieces;
	private Pieces currentPieces; // is used to check whose move is it.
	JButton jb;

	// variable below are used to distinguish between
	// first and second button press
	private int x = -1;
	private int y = -1;
	private int nx;
	private int ny;
	private boolean moved = false;

	// used to set frame dimension
	private final static Dimension FRAME_DIMENSION = new Dimension(600, 600);

	// constructor creates board with 64 buttons
	public GraphicalDisplay(Board b, Pieces p1, Pieces p2) {
		pieces1 = p1;
		pieces2 = p2;
		chessBoard = b;
		t = new TextDisplay(chessBoard);
		setTitle("JChess");
		setSize(FRAME_DIMENSION);
		setVisible(true);
		setBackground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(8, 8));

		for (int i = 0; i < PieceCode.YSIZE; i++) {
			for (int j = 0; j < PieceCode.XSIZE; j++) {

				jb = new JButton();
				jb.addActionListener(new Action());

				// create chess board design
				contentPane.add(jb);
				if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
					jb.setBackground(Color.DARK_GRAY);
				} else {
					jb.setBackground(Color.WHITE);
				}
				chessBoardSquares[j][i] = jb;
			}
		}
	}

	// method used to attach image to each piece
	public void addImage(String iName, int x, int y) {
		try {
			Image img = ImageIO.read(getClass().getResource(iName));
			chessBoardSquares[x][y].setIcon(new ImageIcon(img));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// method used to display each piece
	public void displayBoard(Pieces pieces) {
		Piece cBoard[][] = new Piece[PieceCode.XSIZE][PieceCode.YSIZE];
		currentPieces = pieces;
		// checks whose move is it
		if (currentPieces == pieces1)
			opponentPieces = pieces2;
		else
			opponentPieces = pieces1;

		cBoard = chessBoard.getBoard();
		// image are attached to each piece
		for (int i = 0; i < PieceCode.YSIZE; i++) {
			for (int j = 0; j < PieceCode.XSIZE; j++) {
				if (cBoard[j][i] != null) {
					if (cBoard[j][i].getChar() == PieceCode.ROOKWHITE) {
						this.addImage("WhiteRook.png", j, i);
					} else if (cBoard[j][i].getChar() == PieceCode.ROOKBLACK) {
						this.addImage("BlackRook.png", j, i);
					} else if (cBoard[j][i].getChar() == PieceCode.KNIGHTWHITE) {
						this.addImage("WhiteKnight.png", j, i);
					} else if (cBoard[j][i].getChar() == PieceCode.KNIGHTBLACK) {
						this.addImage("BlackKnight.png", j, i);
					} else if (cBoard[j][i].getChar() == PieceCode.BISHOPWHITE) {
						this.addImage("WhiteBishop.png", j, i);
					} else if (cBoard[j][i].getChar() == PieceCode.BISHOPBLACK) {
						this.addImage("BlackBishop.png", j, i);
					} else if (cBoard[j][i].getChar() == PieceCode.KINGWHITE) {
						this.addImage("WhiteKing.png", j, i);
					} else if (cBoard[j][i].getChar() == PieceCode.KINGBLACK) {
						this.addImage("BlackKing.png", j, i);
					} else if (cBoard[j][i].getChar() == PieceCode.QUEENWHITE) {
						this.addImage("WhiteQueen.png", j, i);
					} else if (cBoard[j][i].getChar() == PieceCode.QUEENBLACK) {
						this.addImage("BlackQueen.png", j, i);
					} else if (cBoard[j][i].getChar() == PieceCode.PAWNWHITE) {
						this.addImage("WhitePawn.png", j, i);
					} else {
						this.addImage("BlackPawn.png", j, i);
					}

				} else {
					chessBoardSquares[j][i].setIcon(null);
				}
			}
		}

	}

	// method checks if move was made
	public boolean isMoveMade() {
		return moved;
	}

	// non static class for ActionListener
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Piece piece;

			for (int i = 0; i < PieceCode.YSIZE; i++) {
				for (int j = 0; j < PieceCode.XSIZE; j++) {
					if (e.getSource().equals(chessBoardSquares[j][i])) {

						// attaches co-ordinates for current position of the piece
						if (x == -1 && y == -1) {
							x = j;
							y = i;

							// attaches co-ordinates for new position of the piece
						} else {
							nx = j;
							ny = i;
							piece = chessBoard.getPiece(x, y);

							if (piece != null) {
								int pieceColour = piece.getColour();
								int opponentColour = opponentPieces.getPiece(0).getColour();

								// check if colour of piece is the same as player colour
								if (pieceColour != opponentColour) {
									System.out.println(piece);
									boolean flag = chessBoard.occupied(nx, ny);
									Move move = new Move(piece, x, y, nx, ny, flag);

									ArrayList<Move> listOfMoves = new ArrayList<Move>();

									listOfMoves = piece.availableMoves();
									for (Move m : listOfMoves) {
										// checks if move is available for chosen piece
										if (m.equals(move)) {

											if (flag) {
												Piece opponentPiece = chessBoard.getPiece(nx, ny);
												opponentPieces.delete(opponentPiece);
											}

											chessBoard.setPosition(x, y, null);
											chessBoard.setPosition(nx, ny, piece);
											piece.setPosition(nx, ny);
											moved = true;
										}
									}
									displayBoard(opponentPieces);
									t.displayBoard(opponentPieces);
									x = -1;
									y = -1;
									moved = true;
								}
							}
							x = -1;
							y = -1;

						}
						moved = false;

					}
				}
			}
		}
	}
}
