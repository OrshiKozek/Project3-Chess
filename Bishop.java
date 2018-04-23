public class Bishop extends ChessPiece {
	
	private double dbl;

	public Bishop(String name, int xpos, int ypos, String marker){
		super(name, xpos, ypos);
		setMarker(marker);
	}

	public int move(int newX, int newY) throws ArithmeticException{
		//can move in any diagonal direction
		//check  slope of lines--> if equal to 1, or -1, then the move is legal

		int nowX = getXpos();
		int nowY = getYpos();
		int slope = 0;

        int slopeA = nowY-newY;
        int slopeB = nowX-newX;

        try{
            slope = slopeA/slopeB;
        }
        catch (ArithmeticException e){
            System.out.println(getName());
            System.out.println("You cannot move horizontally. This is the exception statement.");
        }



		if (slope == 1 || slope == -1){ //if the slope is +-1, then the move is legal
            System.out.println("Legal move");
            setXpos(newX);
            setYpos(newY);
            return 0;
        }
        else{
		    //if the move is not diagonal, then it is not legal
            System.out.println(getName());
            System.out.println("You can only move diagonally. THis is the else statement");
            return -1;
        }
	}


}