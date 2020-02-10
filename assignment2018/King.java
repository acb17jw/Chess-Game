package assignment2018;
import java.util.ArrayList;

import assignment2018.codeprovided.*;

/**
 * King.java
 *
 * Concrete class to represent a King
 *
 * @author Jakub Wielgorski
 * 
 */
public class King extends Piece {
	
	 public King(int ix, int iy, int c, Board b) {
	        super(PieceCode.KING, ix, iy, c, b);
	    }

	@Override
	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		 // obtain current co-ordinates
		 int x = this.getX();
	     int y = this.getY();
	     
	     ArrayList<Move> kingMoves = new ArrayList<Move>();
	     
	     Move theMove = null;
	     // represents diagonal move (up, right)
	     if(!getBoard().outOfRange(x+1, y-1)) {
	    	 
	    	 if(!getBoard().occupied(x+1, y-1)) {
	    		 theMove = new Move(this, x, y, x+1, y-1, false);
	    		 kingMoves.add(theMove);	    		 
	    	 }
	    	 if(getBoard().occupied(x+1,y-1)
	    			  && (getBoard().getPiece(x+1, y-1).getColour() != this.getColour())) {
	    		 theMove = new Move(this, x, y, x+1, y-1, true);
	    		 kingMoves.add(theMove);	
	    	 }
	     }
	     // represents move up
	     if(!getBoard().outOfRange(x, y-1)) {
	    	 
	    	 if(!getBoard().occupied(x, y-1)) {
	    		 theMove = new Move(this, x, y, x, y-1, false);
	    		 kingMoves.add(theMove);	    		 
	    	 }
	    	 if(getBoard().occupied(x,y-1)
	    			  && (getBoard().getPiece(x, y-1).getColour() != this.getColour())) {
	    		 theMove = new Move(this, x, y, x, y-1, true);
	    		 kingMoves.add(theMove);	
	    	 }
	     }
	     // represents diagonal move (up, left)
	     if(!getBoard().outOfRange(x-1, y-1)) {
 	 
	    	 if(!getBoard().occupied(x-1, y-1)) {
	    		 theMove = new Move(this, x, y, x-1, y-1, false);
	    		 kingMoves.add(theMove);	    		 
	    	 }
	    	 if(getBoard().occupied(x-1,y-1)
	    			 && (getBoard().getPiece(x-1, y-1).getColour() != this.getColour())) {
	    		 theMove = new Move(this, x, y, x-1, y-1, true);
	    		 kingMoves.add(theMove);	
	    	 }
	     }  
	     
	     // represents diagonal move (down, right)
	     if(!getBoard().outOfRange(x+1, y+1)) {
	    	 
	    	 if(!getBoard().occupied(x+1, y+1)) {
	    		 theMove = new Move(this, x, y, x+1, y+1, false);
	    		 kingMoves.add(theMove);	    		 
	    	 }
	    	 if(getBoard().occupied(x+1,y+1)
	    			  && (getBoard().getPiece(x+1, y+1).getColour() != this.getColour())) {
	    		 theMove = new Move(this, x, y, x+1, y+1, true);
	    		 kingMoves.add(theMove);	
	    	 }
	     }
	     
	     // represents move down, right
	     if(!getBoard().outOfRange(x, y+1)) {
	    	 
	    	 if(!getBoard().occupied(x, y+1)) {
	    		 theMove = new Move(this, x, y, x, y+1, false);
	    		 kingMoves.add(theMove);	    		 
	    	 }
	    	 if(getBoard().occupied(x,y+1)
	    			  && (getBoard().getPiece(x, y+1).getColour() != this.getColour())) {
	    		 theMove = new Move(this, x, y, x, y+1, true);
	    		 kingMoves.add(theMove);	
	    	 }
	     }
	     
	     // represents diagonal move (down, left)
	     if(!getBoard().outOfRange(x-1, y+1)) {
	    	 
	    	 if(!getBoard().occupied(x-1, y+1)) {
	    		 theMove = new Move(this, x, y, x-1, y+1, false);
	    		 kingMoves.add(theMove);	    		 
	    	 }
	    	 if(getBoard().occupied(x-1,y+1)
	    			  && (getBoard().getPiece(x-1, y+1).getColour() != this.getColour())) {
	    		 theMove = new Move(this, x, y, x-1, y+1, true);
	    		 kingMoves.add(theMove);	
	    	 }
	     }
	     
	     // represents move right
	     if(!getBoard().outOfRange(x+1, y)) {
	    	 
	    	 if(!getBoard().occupied(x+1, y)) {
	    		 theMove = new Move(this, x, y, x+1, y, false);
	    		 kingMoves.add(theMove);	    		 
	    	 }
	    	 if(getBoard().occupied(x+1,y)
	    			  && (getBoard().getPiece(x+1, y).getColour() != this.getColour())) {
	    		 theMove = new Move(this, x, y, x+1, y, true);
	    		 kingMoves.add(theMove);	
	    	 }
	     }
	     //represents move left
	     if(!getBoard().outOfRange(x-1, y)) {
	    	 
	    	 if(!getBoard().occupied(x-1, y)) {
	    		 theMove = new Move(this, x, y, x-1, y, false);
	    		 kingMoves.add(theMove);	    		 
	    	 }
	    	 if(getBoard().occupied(x-1,y)
	    			  && (getBoard().getPiece(x-1, y).getColour() != this.getColour())) {
	    		 theMove = new Move(this, x, y, x-1, y, true);
	    		 kingMoves.add(theMove);	
	    	 }
	     }
	  // returns null if there are not available moves for king
	     if (kingMoves.isEmpty())
	            return null;
	        return kingMoves;
	     
	}

}
