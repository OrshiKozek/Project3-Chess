public class Rook extends ChessPiece {

	private double dbl;

	public Rook(int number, String name, double dbl){
		super(number, name);
		this.dbl = dbl;
	}

	public int move(){
		return 2;
	}

	public double printDouble(){
		return dbl;
	}
	
}