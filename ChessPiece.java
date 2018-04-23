import java.lang.Math;
public abstract class ChessPiece {

	private int number;
	private String name;
	private int xpos;
	private int ypos;
	private String marker;


	public ChessPiece(int number, String name, int xpos, int ypos){
		this.number = number;
		this.name = name;
		this.xpos = xpos;
		this.ypos = ypos;
		this.marker = " --- "; //default marker


	}

	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public int getXpos() {
		return xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	public abstract int move(int xpos, int ypos);
}