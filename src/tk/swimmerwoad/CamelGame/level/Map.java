package tk.swimmerwoad.CamelGame.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Map extends Level {
	
	private static double wi;
	private static double he;
	
	public Map(String path) {
		super(path);
	}
	
	protected void loadLevel(String path){
		try{
			BufferedImage image = ImageIO.read(Map.class.getResource(path));
			int w = width = image.getWidth();
			wi = w;
			int h = height = image.getHeight();
			he = h;
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch(IOException e){
			e.printStackTrace();
			System.out.println("EXCEPTION! Level File did not load properly");
		}
	}
	
	protected void generateLevel(){
		
	}
	
	public double getWidth(){
		return wi;
	}
	
	public double getHeight(){
		return he;
	}

}