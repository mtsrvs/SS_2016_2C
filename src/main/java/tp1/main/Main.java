package tp1.main;

import java.util.List;

import org.jfree.ui.RefineryUtilities;

import tp1.model.Cell;
import tp1.model.Particle;
import tp1.model.Position;
import tp1.plot.Graphic2D;
import tp1.simulation.BrutalForce;
import tp1.simulation.CellIndexMethod;
import tp1.simulation.Simulation;
import tp1.utils.FileGenerator;
import tp1.utils.ParticlesGenerator;
import tp1.utils.PositionGenerator;
import tp1.utils.RadiusGenerator;

public class Main {

	/*
	 * Parametros de entrada
	 * 
	 * n = cantidad de particulas 
	 * l = largo 
	 * rc = radio de cercania 
	 * r = radio de las particulas 
	 * m = cantidad de celdas en filas/columnas
	 */
	public static void main(String args[]) {
		int n = 0;
		int l = 0;
		float rc = 0;
		float r = 0;
		int m = 0;
		boolean periodicBoundary = false;
		
		if (args.length == 6) {
			n = Integer.valueOf(args[0]);
			l = Integer.valueOf(args[1]);
			rc = Float.valueOf(args[2]);
			r = Float.valueOf(args[3]);
			m = Integer.valueOf(args[4]);
			periodicBoundary = Boolean.valueOf(args[5]);
		} else {
			System.out.println("Faltan Parametros");
			return;
		}

		List<Position> listPosition = PositionGenerator.generateN(n, l);
		List<Float> listRadius = RadiusGenerator.generate(r, n);
		List<Particle> listParticle = ParticlesGenerator.generate(listPosition,
				listRadius);

		//Genero los archivos estatico y dinamico
		FileGenerator.staticFile(n, l, listParticle);
		FileGenerator.dynamicFile(listParticle);
			
		Cell[][] matrix = new Cell[m][m];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = new Cell();
			}
		}

		int row;
		int col;
		for (Particle p : listParticle) {
			row = (int) p.getPosition().getY() / m;
			col = (int) p.getPosition().getX() / m;

			matrix[row][col].addParticle(p);
		}

		long start = System.nanoTime();    

//		Simulation CIM = new CellIndexMethod(n, l, rc, r, m, matrix, periodicBoundary);
//		CIM.run();

		Simulation BF = new BrutalForce(n, l, rc, r, m, listParticle);
		BF.run();

		long elapsedTime = System.nanoTime() - start;
		System.out.println("Simulation time: " + elapsedTime);
		
        final Graphic2D demo = new Graphic2D("PARTICULAS!", listParticle);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
		
	}
}
