package tk.swimmerwoad.CamelGame.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StartingLevel extends Level {
	
	public StartingLevel(String path) {
		super(path);
	}
	
	protected void loadLevel(String path){
		try{
			BufferedImage image = ImageIO.read(StartingLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch(IOException e){
			e.printStackTrace();
			System.out.println("EXCEPTION! Level File did not load properly");
		}
	}
	
	protected void generateLevel(){
		
	}

}
