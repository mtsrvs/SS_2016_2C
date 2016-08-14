package tp1.model;

import java.util.ArrayList;
import java.util.List;

public class Particle {

	private Position position;
	private float radius;
	private List<Particle> neigborhood;
	
	//TODO deberia agregar como una lista que refiera a las particular vecinas...
	
	public Particle(Position position, float radius) {
		this.position = position;
		this.radius = radius;
		this.neigborhood = new ArrayList<Particle>();
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

	public List<Particle> getNeigborhood() {
		return neigborhood;
	}

	public void addNeigborhood(Particle p) {
		this.neigborhood.add(p);
	}
}
