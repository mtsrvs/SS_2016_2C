package tp1.classes;

public class Particle {

	private Position position;
	private float radius;
	//TODO deberia agregar como una lista que refiera a las particular vecinas...
	
	public Particle(Position position, float radius) {
		this.position = position;
		this.radius = radius;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
	
	public String toString() {
		return "[PARTICLE position:"+ this.position + " radius:"+this.radius+"]"; 
	}
}
