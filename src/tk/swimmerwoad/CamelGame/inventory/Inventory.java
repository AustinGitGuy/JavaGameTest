package tk.swimmerwoad.CamelGame.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tk.swimmerwoad.CamelGame.entity.mob.Player;
import tk.swimmerwoad.CamelGame.input.Mouse;
import tk.swimmerwoad.CamelGame.inventory.armor.WoodenHelm;

public class Inventory {
	
	public static Rectangle gui = new Rectangle (0, 0, 200, 900);
	public static String goldString = "Gold: " + Integer.toString(Gold.amount);
	public static String aleString = "Ale: " + Integer.toString(Ale.amount);
	public static String ironString = "Iron Ingot: " + Integer.toString(IronIngot.amount);
	public static String goldIString = "Gold Ingot: " + Integer.toString(GoldIngot.amount);
	public static String copperString = "Copper Ingot: " + Integer.toString(CopperIngot.amount);
	public static String roseString = "Rose Gold: " + Integer.toString(RoseGold.amount);
	public static String woodHelmString = "Wooden Helm: " + Integer.toString(WoodenHelm.amount);
	
	private BufferedImage ironIngot;
	private BufferedImage goldIngot;
	
	public static String moveString = "Move Level: " + Integer.toString(Player.MoveLevel);
	public static String bashString = "Bash Level: " + Integer.toString(Player.BashLevel);
	public static String vigString = "Vigilante Level: " + Integer.toString(Player.VigLevel);
	
	public static Color Brown = new Color(139, 69, 19);
	public static boolean[] slot = new boolean[7];
	
	public static boolean items = true;
	public static boolean armor = false;
	public static boolean crafting = false;
	public boolean skills = false;
	@SuppressWarnings("unused")
	private int equip = 0;
	
	public Inventory(){
		try {
			ironIngot = (ImageIO.read(new File("./res/textures/ironIngot.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			goldIngot = ((ImageIO.read(new File("./res/textures/goldIngot.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Remember to fix the Olocations
	public void render(Graphics g){
		Graphics2D gi = (Graphics2D) g;
		g.setColor(Color.CYAN);
		gi.draw(gui); //Main gui
		g.fillRect(0, 0, 200, 900); //Main gui: 200 width, 900 height
		g.setColor(Color.BLACK);
		g.fillRect(201, 0, 4, 25); //GUI - Item line
		g.setColor(Color.CYAN);
		g.fillRect(205, 0, 51, 25); //Item tab
		g.setColor(Color.BLACK);
		g.fillRect(256, 0, 4, 25); //Item - Armor line
		g.setColor(Color.CYAN);
		g.fillRect(260, 0, 51, 25); //Armor tab
		g.setColor(Color.BLACK);
		g.fillRect(311, 0, 4, 25); //Armor - Crafting Tab
		g.setColor(Color.CYAN);
		g.fillRect(315, 0, 51, 25); //Crafting Tab
		g.setColor(Color.BLACK);
		g.fillRect(366, 0, 4, 25); //Crafting - Skills Tab
		g.setColor(Color.CYAN);
		g.fillRect(370, 0, 51, 25); //Skills Tab
		g.setColor(Color.BLACK);
		g.drawString("Items", 215, 17);
		g.drawString("Armor", 269 ,17);
		g.drawString("Crafting", 320, 17);
		g.drawString("Skills", 375, 17);
		if(items){
			if(Gold.amount >= 1){
				g.setColor(Color.BLACK);
				g.drawString(goldString, Gold.sLocationX, Gold.sLocationY);
			}
			if(Ale.amount >= 1){
				g.setColor(Color.BLACK);
				g.drawString(aleString, Ale.sLocationX, Ale.sLocationY);
				
			}
			if(IronIngot.amount >= 1){
				g.setColor(Color.BLACK);
				g.drawString(ironString, IronIngot.sLocationX, IronIngot.sLocationY);
			}
			if(GoldIngot.amount >= 1){
				g.setColor(Color.BLACK);
				g.drawString(goldIString, GoldIngot.sLocationX, GoldIngot.sLocationY);
			}
			if(CopperIngot.amount >= 1){
				g.setColor(Color.BLACK);
				g.drawString(copperString, CopperIngot.sLocationX, CopperIngot.sLocationY);
			}
			if(RoseGold.amount >= 1){
				g.setColor(Color.BLACK);
				g.drawString(roseString, RoseGold.sLocationX, RoseGold.sLocationY);
			}
			if(WoodenHelm.amount >= 1){
				g.setColor(Color.BLACK);
				g.drawString(woodHelmString, WoodenHelm.sLocationX, WoodenHelm.sLocationY);
			}
			equipStuff(g);
		}
		else if(armor){
			g.setColor(Color.BLACK);
			g.drawRect(87, 50, 25, 25); //Head
			g.drawRect(87, 80, 25, 25); //Body
			g.drawRect(122, 80, 25, 25); //Left Arm
			g.drawRect(157, 80, 25, 25); //Left Accessory
			g.drawRect(104, 115, 25, 25); //Left Leg
			g.drawRect(104, 150, 25, 25); //Left Foot
			g.drawRect(52, 80, 25, 25); //Right Arm
			g.drawRect(17, 80, 25, 25); //Right Accessory
			g.drawRect(70, 115, 25, 25); //Right Leg
			g.drawRect(70, 150, 25, 25); //Right Foot
		}
		else if(skills){
			g.setColor(Color.RED);
			g.drawString(moveString, 10, 50);
			g.drawString(bashString, 10, 65);
			g.drawString(vigString, 10, 80);
		}
	}
	
	public void update(){
		goldString = "Gold: " + Integer.toString(Gold.amount);
		
		roseString = "Rose Gold: " + Integer.toString(RoseGold.amount);
		copperString = "Copper Ingot: " + Integer.toString(CopperIngot.amount);
		ironString = "Iron Ingot: " + Integer.toString(IronIngot.amount);
		goldIString = "Gold Ingot: " + Integer.toString(GoldIngot.amount);
		
		aleString = "Ale: " + Integer.toString(Ale.amount);
		
		moveString = "Move Level: " + Integer.toString(Player.MoveLevel);
		bashString = "Bash Level: " + Integer.toString(Player.BashLevel);
		vigString = "Vigilante Level: " + Integer.toString(Player.VigLevel);
		
		woodHelmString = "Wooden Helm: " + Integer.toString(WoodenHelm.amount);
		
		if(Mouse.getXc() >= 315 && Mouse.getXc() <= 366){
			if(Mouse.getYc() >= 0 && Mouse.getYc() <= 25){
				items = false;
				armor = false;
				crafting = true;
				Mouse.reset();
			}
		}
		else if(Mouse.getXc() >= 370 && Mouse.getXc() <= 421){
			if(Mouse.getYc() >= 0 && Mouse.getYc() <= 25){
				items = false;
				armor = false;
				crafting = false;
				skills = true;
				Mouse.reset();
			}
		}
	}
	
	public void equipStuff(Graphics g){
		if(WoodenHelm.amount >= 1){
			if(Mouse.getXc() >= 0 && Mouse.getXc() <= 200){
				if(Mouse.getYc() >= WoodenHelm.sLocationY - 10 && Mouse.getYc() <= WoodenHelm.sLocationY + 5){
					g.setColor(Color.CYAN);
					g.fillRect(200, WoodenHelm.sLocationY - 10, 50, 15);
					g.setColor(Color.BLACK);
					g.drawString("Equip", 205, WoodenHelm.sLocationY);
					equip = WoodenHelm.slot;
				}
			}
			Mouse.reset();
		}
	}

	public BufferedImage getIronIngot() {
		return ironIngot;
	}

	public BufferedImage getGoldIngot() {
		return goldIngot;
	}
	
}
