public class Bishop extends ChessPiece {
	
	private double dbl;

	public Bishop(int number, String name, double dbl){
		super(number, name);
		this.dbl = dbl;
	}

	public int move(){
		return 4;
	}

	public double printDouble(){
		return dbl;
	}
}