package tp1.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tp1.model.Position;

public class PositionGenerator {

	public static Position generate(int n, float l) {
		Random random = new Random();
		
		float row = random.nextFloat()*l;
		float col = random.nextFloat()*l;
		
		
		return new Position(row, col);
	}
	
	public static List<Position> generateN(int n, float l) {
		List<Position> list = new ArrayList<Position>();
		Random random = new Random();
		float row;
		float col;
		
		for(int i = 0; i < n; i++) {
			row = random.nextFloat()*l;
			col = random.nextFloat()*l;
			
			list.add(new Position(row, col));
		}
		
		return list;
	}
}
