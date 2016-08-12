package tp1.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import tp1.classes.Particle;

public class FileGenerator {

	public static void staticFile(int n, int l, List<Particle> listParticle) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("input/static.txt", "UTF-8");
			writer.println(n);
			writer.println(l);
			
			for(Particle p: listParticle) {
				writer.println(p.getPosition().print());
			}
			writer.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dynamicFile(List<Particle> listParticle) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("input/dynamic.txt", "UTF-8");			
			for(Particle p: listParticle) {
				writer.println(p.getRadius());
			}
			writer.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
}
