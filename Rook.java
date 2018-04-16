public class Rook extends ChessPiece {

	private double dbl;

	public Rook(int number, String name, int xpos, int ypos, String marker, double dbl){
		super(number, name, xpos, ypos);
		this.dbl = dbl;
		setMarker(marker);
	}

	public int move(int newX, int newY){
		return -1;
	}

	public double printDouble(){
		return dbl;
	}
	
}