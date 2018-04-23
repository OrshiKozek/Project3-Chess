import java.sql.SQLOutput;

public class Knight extends ChessPiece {
	
	private double dbl;

	public Knight( String name, int xpos, int ypos, String marker){
		super(name, xpos, ypos);
		setMarker(marker);
	}

	public int move(int newY, int newX){
		//moves in an L shape-- two steps forward, backward, left or right, then one perpendicular to the other two
        //check if first two are in line with current position
        //then check if final position is over one

        int nowX = getXpos();
        int nowY = getYpos();

        int distX = Math.abs(nowX - newX); //distance between old and new x coordinates
        int distY = Math.abs(nowY - newY); //distance between old and new y coordinates

        //if xnow and xnew are the same, then the move is illegal
        if(nowX == nowY){
            System.out.println(getName());
            System.out.println("Illegal move");
            return -1;
        }
        //if xnow and xnew are within one steps of each other, the move MAY be legal- could be illegal
        else if (distX == 1 ){
            //check if ynew is two bigger or two smaller than ynow
            if(distY == 2){ //yes = legal
                System.out.println("Legal move");
                setXpos(newX);
                setYpos(newY);
                return 0;
            }
            else{ //no = illegal
                System.out.println("Illegal move");
                return -1;
            }
        }
        else if (distX == 2){ //if xnow and xnew are within two steps of each other, then move MAY be legal
            //check if ynew is one bigger or smaller than ynow
            if (distY == 1){ //yes = legal
                System.out.println("Legal move");
                setXpos(newX);
                setYpos(newY);
                return 0;
            }
            else { //no = illegal
                System.out.println("Illegal move");
                return -1;
            }
        }
        else{
            System.out.println("Illegla move");
            return -1;
        }
	}


}