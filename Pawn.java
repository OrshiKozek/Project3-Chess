public class Pawn extends ChessPiece {

	private double dbl;

	public Pawn(String name, int xpos, int ypos, String marker){
		super(name, xpos, ypos);
		setMarker(marker);
	}

	public int move(int newY, int newX){
		int nowX = getXpos();
		int nowY = getYpos();


		//Pawn can move forward either one or two on first move, then only forward one after that

//        if( nowX == 6 ){ //if pawn is still in the starting position

            //check if moving forward- y-position should be the same throughout
            if(newY != nowY){

                System.out.println(getName());
                System.out.println("You cannot move sideways");
                return -1;
            }

            if(newX == nowX - 1 || newX == nowX - 2){
                setXpos(newX);
            }
            else{
                System.out.println(getName());
                System.out.println("You cannot move forward more than two spaces");
                return -1;
            }
//        }
//        else {
//            if(newY != nowY){
//                System.out.println(getName());
//                System.out.println("You cannot move sideways");
//                return -1;
//            }
//            if(newX == nowX-1){
//                setXpos(newX);
//            }
//            else{
//                System.out.println(getName());
//                System.out.println("You cannot move forward more than one spaces");
//                return -1;
//            }
//        }

    return 0;
	}




}
