public class ChessBoard{
		
	private static String[][] board = new String[9][9];
	
	public static void main(String[] args) {
		createBoard();
		displayBoard();

		Pawn first = new Pawn(1, "pawn", 1.1);

		System.out.println(first.printName());
		System.out.println(first.printNumber());
		System.out.println(first.printDouble());
		System.out.println(first.move());

		Rook second = new Rook(2, "rook", 2.2);

		System.out.println(second.printName());
		System.out.println(second.printNumber());
		System.out.println(second.printDouble());
		System.out.println(second.move());

		Knight third = new Knight(3, "knight", 3.3);

		System.out.println(third.printName());
		System.out.println(third.printNumber());
		System.out.println(third.printDouble());
		System.out.println(third.move());

		Bishop fourth = new Bishop(4, "bishop", 4.4);

		System.out.println(fourth.printName());
		System.out.println(fourth.printNumber());
		System.out.println(fourth.printDouble());
		System.out.println(fourth.move());

		

	}

	public static void createBoard(){
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

	public static void displayBoard(){
		for (int i = 0; i < board.length; i++) {
			System.out.println("\n");
			// System.out.println();
			for (int j=0; j < 9; j++ ) {
				System.out.print(board[i][j]);
			}		
		}
	}





}