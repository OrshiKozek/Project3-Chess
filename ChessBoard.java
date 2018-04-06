public class ChessBoard{
		
	private static String[][] board = new String[9][9];
	
	public static void main(String[] args) {
		createBoard();
		displayBoard();




		

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