package tp1.utils;

import java.util.ArrayList;
import java.util.List;

import tp1.classes.Particle;
import tp1.classes.Position;

public class ParticlesGenerator {

	public static List<Particle> generate(List<Position> listPosition, List<Float> listRadius) {
		List<Particle> listParticle = new ArrayList<Particle>();
		
		for (int i= 0; i < listPosition.size(); i++) {
			listParticle.add(new Particle(listPosition.get(i), listRadius.get(i)));
		}
		
		return listParticle;
	}
}
