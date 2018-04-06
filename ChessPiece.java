public abstract class ChessPiece {

	private String name;

	public ChessPiece(String name){
		this.name = name;
	}

	public abstract int move();
	
}