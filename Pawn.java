public class Pawn extends ChessPiece {

	private double dbl;

	public Pawn(int number, String name, int xpos, int ypos, String marker, double dbl){
		super(number, name, xpos, ypos);
		this.dbl = dbl;
		setMarker(marker);
	}

	public int move(){
		return 1;
	}

	public double printDouble(){
		return dbl;
	}


}
