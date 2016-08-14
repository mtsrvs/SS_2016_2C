package tp1.simulation;

import java.util.List;

import tp1.model.Particle;
import tp1.utils.Distance;

public class BrutalForce implements Simulation {
	private int n = 0;
	private int l = 0;
	private float rc = 0;
	private float r = 0;
	private int m = 0;
	private List<Particle> listParticle;
	
	public BrutalForce(int n, int l, float rc, float r, int m, List<Particle> listParticle) {
		this.n = n;
		this.l = l;
		this.rc = rc;
		this.r = r;
		this.m = m;
		this.listParticle = listParticle;
	}
	
	/**
	 * Compara una particula con todas las demas particulas
	 */
	public void run() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j != i && j < n; j++) {
				if(Distance.isNeigborhood(listParticle.get(i), listParticle.get(j), rc)) {
					listParticle.get(i).addNeigborhood(listParticle.get(j));
				}
			}
		}
	}
	
}
