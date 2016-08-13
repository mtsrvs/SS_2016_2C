package tp1.main;

import java.util.List;

import org.jfree.ui.RefineryUtilities;

import tp1.classes.Cell;
import tp1.classes.Particle;
import tp1.classes.Position;
import tp1.plot.Graphic2D;
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

		if (args.length == 5) {
			n = Integer.valueOf(args[0]);
			l = Integer.valueOf(args[1]);
			rc = Float.valueOf(args[2]);
			r = Float.valueOf(args[3]);
			m = Integer.valueOf(args[4]);
		} else {
			System.out.println("Faltan Parametros");
			return;
		}

		List<Position> listPosition = PositionGenerator.generateN(n, l);
		List<Float> listRadius = RadiusGenerator.generate(r, n);
		List<Particle> listParticle = ParticlesGenerator.generate(listPosition,
				listRadius);

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

        final Graphic2D demo = new Graphic2D("PARTICULAS!", listParticle);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
		
	}
}
