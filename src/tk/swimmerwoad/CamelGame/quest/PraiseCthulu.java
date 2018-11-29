package tk.swimmerwoad.CamelGame.quest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import tk.swimmerwoad.CamelGame.graphics.Screen;

public class PraiseCthulu extends Quest {

	public String name;
	public static boolean questInit = false;
	public static boolean questDone = false;
	public static boolean questAlt = false;
	public static boolean questPhase1 = false;
	public static boolean questPhase2 = false;
	public static boolean questy = false;
	public static boolean questn = false;
	
	public PraiseCthulu(String name) {
		super(name);
	}
	
	public static void questStart(){
		questInit = true;
		questPhase1 = true;
	}
	
	public void render(Screen screen, Graphics g, BufferStrategy bs) {
		Font font = new Font("Arial", 0, 30);
		Font font2 = new Font("Comic Sans MS", 0, 20);
		if(questPhase1){
			g.setColor(Color.RED);
			g.setFont(font);
			g.drawString("Praise Cthulu!", 330, 50);
			g.setFont(font2);
			g.drawString("Do you want to worship Cthulu?", 300, 450);
			g.setColor(Color.BLUE);
			g.drawString("Yes", 300, 475);
			g.drawString("No", 550, 475);
			screen.clear();
			g.dispose();
			bs.show();
		}
		if(questPhase2){
			g.setColor(Color.RED);
			g.setFont(font2);
			if(questy){
				g.drawString("Welcome to the cult of Cthulu! May Cthulu bless you with his magic!", 134, 450);
				g.setColor(Color.BLUE);
				g.drawString("Thank you brother", 350, 475);
				questDone = true;
			}
			if(questn){
				g.drawString("Get out of here! May Cthulu smite you with his magic!", 200, 450);
				g.setColor(Color.BLUE);
				g.drawString("Good day!", 400, 475);
				questAlt = true;
			}
			screen.clear();
			g.dispose();
			bs.show();
		}
	}
}
