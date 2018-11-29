package tk.swimmerwoad.CamelGame.magic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.quest.PraiseCthulu;

public class CthuluSmite{
	
	public String name = "Cthulu Smite";
	public static boolean used = false;
	private BufferedImage cthulu;
	private Font font = new Font("Comic Sans MS", 0, 20);
	private Color cgreen = new Color(101, 189, 67);
	
	public CthuluSmite(){
		try {
			cthulu = ImageIO.read(new File("./res/images/cthulu.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void render(Screen screen, Graphics g){
		if(used){
			if(PraiseCthulu.questDone){
				g.setColor(cgreen);
				g.setFont(font);
				g.drawImage(cthulu, 50, 120, null);
				g.drawString("Cthulu answers your call!", 50, 200);	
			}
		}
	}
}
