package tk.swimmerwoad.CamelGame.house;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import tk.swimmerwoad.CamelGame.dialogue.HouseManagerTalk;

public class HouseGUI {
	
	public static boolean placing = false;
	public static Rectangle gui = new Rectangle (0, 0, 200, 900);
	public static String couchString = "Couches: " + Integer.toString(HouseManagerTalk.couch);
	public static String chairString = "Chairs: " + Integer.toString(HouseManagerTalk.chair);
	public static String tableString = "Tables: " + Integer.toString(HouseManagerTalk.table);
	public static String TVString = "TVs: " + Integer.toString(HouseManagerTalk.tv);
	
	public void render(Graphics g){
		Graphics2D gi = (Graphics2D) g;
		gi.setColor(Color.CYAN);
		gi.draw(gui);
		gi.fillRect(0, 0, 200, 900);
		g.setColor(Color.RED);
		g.drawString(couchString, 100, 50);
		g.drawString(chairString, 100, 65);
		g.drawString(tableString, 100, 80);
		g.drawString(TVString, 100, 95);
	}
	
	public void update(){
		couchString = "Couches: " + Integer.toString(HouseManagerTalk.couch);
		chairString = "Chairs: " + Integer.toString(HouseManagerTalk.chair);
		tableString = "Tables: " + Integer.toString(HouseManagerTalk.table);
		TVString = "TVs: " + Integer.toString(HouseManagerTalk.tv);
	}
}
