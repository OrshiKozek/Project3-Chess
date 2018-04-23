import java.util.*;
import java.lang.*;
import java.io.*;
//import java.util.ArrayList;
//import java.util.List;

public class ChessBoard{
		
	private static String[][] board = new String[9][9];
	private static List<ChessPiece> pieces = new ArrayList<ChessPiece>();

	public static void main(String[] args) throws FileNotFoundException {
		createBoard();

		File file = new File("input.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNext()) {
            String name = scan.next();

            if (name.equals("move")){

                int oldX = scan.nextInt();
                int oldY = scan.nextInt();
                int newX = scan.nextInt();
                int newY = scan.nextInt();
                System.out.println(name + " " + oldX + " " + oldY + " " + newX + " " + newY);
            }
            else{
                int xpos = scan.nextInt();
                int ypos = scan.nextInt();
                System.out.println(name + " " + xpos + " " + ypos);
                //create all the pieces

                if(name.equals("knight")){
                    Knight k1 = new Knight(name, xpos, ypos, " -h- ");
                    changeCoordinates(k1);
//                    System.out.println(k1.getXpos());
//                    System.out.println(k1.getYpos());
                    pieces.add(k1);
                }
                else if (name.equals("rook")){
                    Rook r1 = new Rook(name, xpos, ypos, " -R- ");
                    changeCoordinates(r1);
                    pieces.add(r1);
                }
                else if (name.equals("bishop")){
                    Bishop b1 = new Bishop(name, xpos, ypos, " -B- ");
                    changeCoordinates(b1);
                    pieces.add(b1);
                }
                else{
                    Pawn p1= new Pawn(name, xpos, ypos, " -P- ");
                    changeCoordinates(p1);
                    pieces.add(p1);

                }

            }
        }



//		displayBoard();


//		Pawn p1 = new Pawn(1, "pawn1", 6, 1, " -P- ", 1.1);
//        Pawn p2 = new Pawn(1, "pawn2", 6, 2, " -P- ", 1.1);
//        Pawn p3 = new Pawn(1, "pawn3", 6, 3, " -P- ", 1.1);
//        Pawn p4 = new Pawn(1, "pawn4", 6, 4, " -P- ", 1.1);
//        Pawn p5 = new Pawn(1, "pawn5", 6, 5, " -P- ", 1.1);
//        Pawn p6 = new Pawn(1, "pawn6", 6, 6, " -P- ", 1.1);
//        Pawn p7 = new Pawn(1, "pawn7", 6, 7, " -P- ", 1.1);
//        Pawn p8 = new Pawn(1, "pawn8", 6, 8, " -P- ", 1.1);

//		Rook r1 = new Rook(2, "rook1", 7, 1, " -R- ",  2.2);
//        Rook r2 = new Rook(2, "rook2", 7, 8, " -R- ",  2.2);


//		Knight k1 = new Knight(3, "knight1", 7, 2," -kn-", 3.3);
//		Knight k2 = new Knight(3, "knight2", 7, 7," -kn-", 3.3);


//		Bishop b1 = new Bishop(4, "bishop1", 7, 3, " -B- ", 4.4);
//        Bishop b2 = new Bishop(4, "bishop2", 7, 6, " -B- ", 4.4);

//        pieces.add(p1);
//        pieces.add(p2);
//        pieces.add(p3);
//        pieces.add(p4);
//        pieces.add(p5);
//        pieces.add(p6);
//        pieces.add(p7);
//        pieces.add(p8);

//        pieces.add(r1);
//        pieces.add(r2);
//
//        pieces.add(k1);
//        pieces.add(k2);
//
//        pieces.add(b1);
//        pieces.add(b2);
        addPieces(pieces);
        displayBoard();
//        board[7][4] = " =Q= ";
//        board[7][5] = " =K= ";
//        displayBoard();

//		movePieces(p1, 4, 1);
//		movePieces(p2, 5, 2);
//		movePieces(p3, 3, 3);
//		movePieces(p4, 5,5);
//		movePieces(p1, 3,1);
//		movePieces(p2, 3, 2);


//        movePieces(k1, 5, 3); // legal move
//        displayBoard();
//        movePieces(k1, 5, 6); // illegal move
//        displayBoard();
//        movePieces(k1, 6, 5); // legal move
//        displayBoard();
//        movePieces(k1, 3, 5); // illegal move

//        displayBoard();
//        movePieces(b2, 5, 7);
//        displayBoard();
//        movePieces(b2, 1, 8);
//        displayBoard();




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

	private static void movePieces(ChessPiece piece, int newX, int newY) {
        int oldX = piece.getXpos();
        int oldY = piece.getYpos();

        int returnVal = piece.move(newX, newY);


        if (returnVal == 0) { //if the move is legal, then change the marker
            board[oldX][oldY] = " --- "; //this changes the marker even if the pawn does not move
            board[piece.getXpos()][piece.getYpos()] = piece.getMarker();
        } else {
            System.out.println("We did not change the marker");
        }
    }

    public static void changeCoordinates(ChessPiece piece){
	    int customX = piece.getXpos();
	    int customY = piece.getYpos();

	    if (customX == 0){
	        piece.setYpos(1);
//            System.out.println(piece.getXpos());
        }
        else if (customX == 1) {
	        piece.setYpos(2);
        }
        else if (customX == 2) {
            piece.setYpos(3);
        }
        else if (customX == 3) {
            piece.setYpos(4);
        }
        else if (customX == 4) {
	        piece.setYpos(5);
        }
        else if (customX == 5) {
            piece.setYpos(6);
        }
        else if (customX == 6) {
            piece.setYpos(7);
        }
        else if (customX == 7) {
            piece.setYpos(8);
        }
        else{
            System.out.println("OUT OF BOUNDS X");
        }
/////////////////////////////////////////////////////
        if (customY == 0){
            piece.setXpos(7);
//            System.out.println(piece.getYpos());
        }
        else if (customY == 1) {
            piece.setXpos(6);
        }
        else if (customY == 2) {
            piece.setXpos(5);
        }
        else if (customY == 3) {
            piece.setXpos(4);
        }
        else if (customY == 4){
	        piece.setXpos(3);
        }
        else if (customY == 5) {
            piece.setXpos(2);
        }
        else if (customY == 6) {
            piece.setXpos(1);
        }
        else if (customY == 7) {
            piece.setXpos(0);
        }
        else{
            System.out.println("OUT OF BOUNDS Y");
        }
    }




    public static class OutOfBoardException extends Exception {
	    //if the given point does not exist on the board
    }

    public static class PathWayException extends Exception {

    }


}