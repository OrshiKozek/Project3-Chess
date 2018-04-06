public class Pawn extends ChessPiece {

	private double dbl;

	public Pawn(int number, String name, double dbl){
		super(number, name);
		this.dbl = dbl;
	}

	public int move(){
		return 1;
	}

	public double printDouble(){
		return dbl;
	}
}