package tp1.simulation;

import tp1.model.Cell;
import tp1.model.Particle;
import tp1.utils.Distance;

public class CellIndexMethod implements Simulation {
	private int n = 0;
	private int l = 0;
	private float rc = 0;
	private float r = 0;
	private int m = 0;
	private Cell[][] matrix;
	private final int[] deltaX = {1,1,1,0};
	private final int[] deltaY = {-1,0,1,1};
	private boolean isPeriodicBoundary = false;
	
	public CellIndexMethod(int n, int l, float rc, float r, int m, Cell[][] matrix, boolean periodicBoundary) {
		this.n = n;
		this.l = l;
		this.rc = rc;
		this.r = r;
		this.m = m;
		this.matrix= matrix;
		this.isPeriodicBoundary = periodicBoundary;
	}

	/**
	 * Compara una particula con las particulas de las celdas vecinas.
	 **/
	public void run() {
		Cell c = null;
		Cell cellNeigborhood = null;
		
		for(int x = 0; x < m; x++) {
			for( int y = 0; y < m; y++) {
				c = matrix[x][y];
				
				for(int i = 0; i < 4; i++) {
					cellNeigborhood = getCell(x + deltaX[i], y + deltaY[i]);
					if(cellNeigborhood != null)
						getParticleNeigborhood(c, cellNeigborhood);
				}
				
			}
		}
	}

	private void getParticleNeigborhood(Cell c, Cell cellNeigborhood) {
		for(Particle pc: c.getListParticle()) {
			for(Particle pcn: cellNeigborhood.getListParticle()) {
				if(Distance.isNeigborhood(pc, pcn, this.rc)) {
					pc.addNeigborhood(pcn);
				}
			}
		}
	}

	private Cell getCell(int x, int y) {
		if( 0<= x && x < m && 0<= y && y < m) {
			return matrix[x][y];
		}
		
		if(isPeriodicBoundary) {
			int valueX = x;
			int valueY = y;
			
			if(x > m)
				valueX = 0;
			if(x < 0)
				valueX = m - 1;
			if(y > m)
				valueY = 0;
			if(y < 0)
				valueY = m - 1;

			return matrix[valueX][valueY];
		}
		
		return null;
	}
}
