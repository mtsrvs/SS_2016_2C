package tp1.classes;

public class Position {

	private float x;
	private float y;

	public Position(float x, float y) {
		this.y = y;
		this.x = x;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public String print() {
		return x+"\t"+y;
	}
	
	public String toString() {
		return "("+x+", "+y+")";
	}
}
