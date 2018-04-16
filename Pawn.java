public class Pawn extends ChessPiece {

	private double dbl;

	public Pawn(int number, String name, int xpos, int ypos, String marker, double dbl){
		super(number, name, xpos, ypos);
		this.dbl = dbl;
		setMarker(marker);
	}

	public int move(int newX, int newY){
		int nowX = getXpos();
		int nowY = getYpos();


		//Pawn can move forward either one or two on first move, then only forward one after that

        if( nowX == 6 ){ //if pawn is still in the starting position
            //check if moving forward- y-position should be the same throughout
            if(newY != nowY){
                //MUST THROW EXCEPTION FOR ILLEGAL MOVE
                System.out.println(getName());
                System.out.println("You cannot move sideways");
                return -1;
            }
            if(newX == nowX - 1 || newX == nowX -2){
                setXpos(newX);
            }
            else{
                //MUST THROW EXCEPTION FOR ILLEGAL MOVE
                System.out.println(getName());
                System.out.println("You cannot move forward more than two spaces");
                return -1;
            }
        }
        else {
            if(newY != nowY){
                //MUST THROW EXCEPTION FOR ILLEGAL MOVE
                System.out.println(getName());
                System.out.println("You cannot move sideways");
                return -1;
            }
            if(newX == nowX-1){
                setXpos(newX);
            }
            else{
                //MUST THROW EXCEPTION FOR ILLEGAL MOVE
                System.out.println(getName());
                System.out.println("You cannot move forward more than one spaces");
                return -1;
            }
        }

    return 0;
	}

	public double printDouble(){
		return dbl;
	}


}
