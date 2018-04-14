public class Knight extends ChessPiece {
	
	private double dbl;

	public Knight(int number, String name, int xpos, int ypos, String marker, double dbl){
		super(number, name, xpos, ypos);
		this.dbl = dbl;
		setMarker(marker);
	}

	public int move(){
		return 3;
	}

	public double printDouble(){
		return dbl;
	}

}