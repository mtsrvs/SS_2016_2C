package tp1.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RadiusGenerator {

	public static float generate(float r) {
		Random random = new Random();
		float radius = random.nextFloat()*r;
		
		return radius;
	}

	public static List<Float> generate(float r, int n) {
		Random random = new Random();
		List<Float> listRadius = new ArrayList<Float>();
		
		for(int i = 0; i < n; i++) {
			listRadius.add(random.nextFloat()*r);			
		}

		return listRadius;
	}
}
