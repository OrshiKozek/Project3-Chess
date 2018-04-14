import java.util.*;
import java.lang.*;
//import java.util.ArrayList;
//import java.util.List;

public class ChessBoard{
		
	private static String[][] board = new String[9][9];
	private static List<ChessPiece> pieces = new ArrayList<ChessPiece>();

	public static void main(String[] args) {
		createBoard();
//		displayBoard();


		Pawn p1 = new Pawn(1, "pawn", 6, 1, " -P- ", 1.1);
        Pawn p2 = new Pawn(1, "pawn", 6, 2, " -P- ", 1.1);
        Pawn p3 = new Pawn(1, "pawn", 6, 3, " -P- ", 1.1);
        Pawn p4 = new Pawn(1, "pawn", 6, 4, " -P- ", 1.1);
        Pawn p5 = new Pawn(1, "pawn", 6, 5, " -P- ", 1.1);
        Pawn p6 = new Pawn(1, "pawn", 6, 6, " -P- ", 1.1);
        Pawn p7 = new Pawn(1, "pawn", 6, 7, " -P- ", 1.1);
        Pawn p8 = new Pawn(1, "pawn", 6, 8, " -P- ", 1.1);

		Rook r1 = new Rook(2, "rook", 7, 1, " -R- ",  2.2);
        Rook r2 = new Rook(2, "rook", 7, 8, " -R- ",  2.2);


		Knight k1 = new Knight(3, "knight", 7, 2," -kn-", 3.3);
		Knight k2 = new Knight(3, "knight", 7, 7," -kn-", 3.3);


		Bishop b1 = new Bishop(4, "bishop", 7, 3, " -B- ", 4.4);
        Bishop b2 = new Bishop(4, "bishop", 7, 6, " -B- ", 4.4);

        pieces.add(p1);
        pieces.add(p2);
        pieces.add(p3);
        pieces.add(p4);
        pieces.add(p5);
        pieces.add(p6);
        pieces.add(p7);
        pieces.add(p8);

        pieces.add(r1);
        pieces.add(r2);

        pieces.add(k1);
        pieces.add(k2);

        pieces.add(b1);
        pieces.add(b2);
        addPieces(pieces);
        board[7][4] = " =Q= ";
        board[7][5] = " =K= ";
        displayBoard();





	}

	private static void createBoard(){
		int ycoord = 7;
		int xcoord = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j=0; j < 9; j++ ) {
				if (i == 8) {
					if (j != 0){
						board[i][j] = " =" + xcoord + "= ";
						xcoord++;
					}
					else{
						board[i][j] = "=== ";
					}
				}
				else if (j == 0) {
					board[i][j] = "=" + ycoord + "= ";
					ycoord--;	
				}
				else {
					board[i][j] = " --- ";
				}
			}		
		}
	}

	private static void displayBoard(){
		for (int i = 0; i < board.length; i++) {
			System.out.println("\n");
			// System.out.println();
			for (int j=0; j < 9; j++ ) {
				System.out.print(board[i][j]);
			}		
		}
		System.out.println();
	}

	private static void addPieces(List<ChessPiece> pieces){
		for (int index = 0; index < pieces.size(); index++) {
		    ChessPiece aPiece = pieces.get(index);
			int xval = aPiece.getXpos();
			int yval = aPiece.getYpos();
			board[xval][yval] = aPiece.getMarker();
		}

	}






}