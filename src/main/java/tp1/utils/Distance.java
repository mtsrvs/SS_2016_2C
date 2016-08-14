package tp1.utils;

import tp1.model.Particle;

public class Distance {

	public static boolean isNeigborhood(Particle p1, Particle p2, float rc) {
		//Esta es la distancia entre los centros de las particulas p1 y p2
		float distP1P2 = (float) Math.sqrt(Math.pow(
				(p2.getPosition().getX() - p1.getPosition().getX()), 2)
				+ Math.pow((p2.getPosition().getY() - p1.getPosition().getY()),
						2));
		
		//A la distancia que obtuve le resto los radios de cada una de las 
		//particulas. Debe ser menor a rc.
		return distP1P2 - p1.getRadius() - p2.getRadius() <= rc;
	}
}
