public class Knight extends ChessPiece {
	
	private double dbl;

	public Knight(int number, String name, double dbl){
		super(number, name);
		this.dbl = dbl;
	}

	public int move(){
		return 3;
	}

	public double printDouble(){
		return dbl;
	}

}