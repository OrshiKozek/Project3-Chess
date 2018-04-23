public class Rook extends ChessPiece {

	private double dbl;

	public Rook(String name, int xpos, int ypos, String marker){
		super(name, xpos, ypos);
		setMarker(marker);
	}

	public int move(int newX, int newY){
		//can move forward, backward left or right only
		int nowX = getXpos();
		int nowY = getYpos();

        //moving forward or backward-- if xpos is the same
		//check if moving forward- y-position should be the same throughout
        if(newX == nowX){ //stays in same column, any x, can move as many
            //as 7 squares in one continuous direction as long as there is no other piece in the way

            setYpos(newY); //since xvalue is the same, only change the y value to new position
            System.out.println("legal vertical move");
            return 0;
        }
        else if(newY == nowY){ //if the yvalues are the same, then piece is moving left or right
            setXpos(newX); //only changes xvalue because y stays the same
            System.out.println("legal horizontal move");
            return 0;
        }
        else{
            //if both the x and the y are different, then it is an illegal move
            System.out.println(getName());
            System.out.println("You can only move forward, backwards, left or right");
            return -1;
        }

	}


	
}