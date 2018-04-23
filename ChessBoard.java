import java.util.*;
import java.lang.*;
import java.io.*;

//import static jdk.vm.ci.amd64.AMD64.CPU;
//import static jdk.vm.ci.amd64.AMD64.k1;
//import java.util.ArrayList;
//import java.util.List;

public class ChessBoard{
		
	private static String[][] board = new String[9][9];
	private static List<ChessPiece> pieces = new ArrayList<ChessPiece>();

	public static void main(String[] args) throws FileNotFoundException {
		createBoard();

		File file = new File("input.txt");
        Scanner scan = new Scanner(file);

        int[] indexOrders = new int[]{1, 3, 2, 0, 5, 0, 0, 0, 0};
        int index = 0;
        while (scan.hasNext()) {
            String name = scan.next();

            if (name.equals("move")){
                int oldX = scan.nextInt();
                int oldY = scan.nextInt();
                int newX = scan.nextInt();
                int newY = scan.nextInt();
                System.out.println(name + " " + oldX + " " + oldY + " " + newX + " " + newY);

                int changedOldY = changeXCoordinates(oldX);
                int changedOldX = changeYCoordinates(oldY);

                int changedX = changeXCoordinates(newX);
                int changedY = changeYCoordinates(newY);


                ChessPiece thisPiece = pieces.get(indexOrders[index]);

                movePieces(changedX, changedY, changedOldX, changedOldY, thisPiece);

                index++;
















            }
            else{
                int xpos = scan.nextInt();
                int ypos = scan.nextInt();
                System.out.println(name + " " + xpos + " " + ypos);
                //create all the pieces

                if(name.equals("knight")){
                    Knight k1 = new Knight(name, xpos, ypos, " -h- ");
                    k1.setYpos(changeXCoordinates(xpos));
                    k1.setXpos(changeYCoordinates(ypos));
                    pieces.add(k1);
                }
                else if (name.equals("rook")){
                    Rook r1 = new Rook(name, xpos, ypos, " -R- ");
                    r1.setYpos(changeXCoordinates(xpos));
                    r1.setXpos(changeYCoordinates(ypos));
                    pieces.add(r1);
                }
                else if (name.equals("bishop")){
                    Bishop b1 = new Bishop(name, xpos, ypos, " -B- ");
                    b1.setYpos(changeXCoordinates(xpos));
                    b1.setXpos(changeYCoordinates(ypos));
                    pieces.add(b1);
                }
                else if (name.equals("pawn")){
                    Pawn p1= new Pawn(name, xpos, ypos, " -P- ");
                    p1.setYpos(changeXCoordinates(xpos));
                    p1.setXpos(changeYCoordinates(ypos));
                    pieces.add(p1);
                }
                else{
                    addPieces(pieces);
                    displayBoard();
                }

            }
        }
        addPieces(pieces);
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











//	private static void movePieces(ChessPiece piece, int newX, int newY) {
    private static void movePieces(int newX, int newY, int oldX, int oldY, ChessPiece piece){
//        int oldX = piece.getXpos();
//        int oldY = piece.getYpos();

        int returnVal = piece.move(newX, newY);


        if (returnVal == 0) { //if the move is legal, then change the marker
            board[oldX][oldY] = " --- "; //this changes the marker even if the pawn does not move
            board[piece.getXpos()][piece.getYpos()] = piece.getMarker();
        } else {
            System.out.println("We did not change the marker");
        }
    }






















    public static int changeXCoordinates(int customX) {

        if (customX == 0) {
            return 1;
        } else if (customX == 1) {
            return 2;
        } else if (customX == 2) {
            return 3;
        } else if (customX == 3) {
            return 4;
        } else if (customX == 4) {
            return 5;
        } else if (customX == 5) {
            return 6;
        } else if (customX == 6) {
            return 7;
        } else if (customX == 7) {
            return 8;
        } else {
            System.out.println("OUT OF BOUNDS X");
            return -1;
        }
    }

    public static int changeYCoordinates(int customY){
        if (customY == 0){
            return 7;
        }
        else if (customY == 1) {
            return 6;
        }
        else if (customY == 2) {
            return 5;
        }
        else if (customY == 3) {
            return 4;
        }
        else if (customY == 4){
            return 3;
        }
        else if (customY == 5) {
            return 2;
        }
        else if (customY == 6) {
            return 1;
        }
        else if (customY == 7) {
            return 0;
        }
        else{
            System.out.println("OUT OF BOUNDS Y");
            return -1;
        }
    }




    public static class OutOfBoardException extends Exception {
	    //if the given point does not exist on the board
    }

    public static class PathWayException extends Exception {

    }


}