public abstract class ChessPiece {

	private int number;
	private String name;


	public ChessPiece(int number, String name){
		this.number = number;
		this.name = name;
	}

	public int printNumber(){
		return number;
	}

	public String printName(){
		return name;
	}

	public abstract int move();
	
}