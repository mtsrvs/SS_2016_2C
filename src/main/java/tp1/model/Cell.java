package tp1.model;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	private List<Particle> listParticle;
	private List<Particle> listHead;
	
	public Cell() {
		this.listParticle = new ArrayList<Particle>();
		this.listHead = new ArrayList<Particle>();
	}
	
	public void addHead(Particle p) {
		this.listHead.add(p);
	}
	
	public void addParticle(Particle p) {
		this.listParticle.add(p);
	}	

	public List<Particle> getListParticle() {
		return this.listParticle;
	}
	
	public List<Particle> getListHead() {
		return this.listHead;
	}
}
