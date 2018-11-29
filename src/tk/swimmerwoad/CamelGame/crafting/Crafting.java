package tk.swimmerwoad.CamelGame.crafting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.input.Mouse;
import tk.swimmerwoad.CamelGame.inventory.CopperIngot;
import tk.swimmerwoad.CamelGame.inventory.GoldIngot;
import tk.swimmerwoad.CamelGame.inventory.Inventory;
import tk.swimmerwoad.CamelGame.inventory.RoseGold;

public class Crafting {
	
	private boolean slot1 = false;
	
	private Rectangle slot1l = new Rectangle(0, 0, 200, 20);
	
	private boolean RoseG = true;
	
	public Crafting(){
		
	}
	
	public void render(Graphics g, Screen screen){
		Graphics2D gi = (Graphics2D) g;
		if(Inventory.crafting){
			if(GoldIngot.amount >= 1){
				if(CopperIngot.amount >= 1){
					if(!slot1 || RoseG){
						g.setColor(Color.BLACK);
						g.drawString("Rose Gold: 1 Gold, 1 Copper", 10, 15);
						gi.draw(slot1l);
						slot1 = true;
						RoseG = true;
					}
				}
			}
		}
	}
	
	public void update(){
		if(Mouse.getXc() >= slot1l.x && Mouse.getXc() <= slot1l.x + slot1l.width){
			if(Mouse.getYc() >= slot1l.y && Mouse.getYc() <= slot1l.y + slot1l.height){
				CopperIngot.amount--;
				GoldIngot.amount--;
				RoseGold.amount++;
				Mouse.reset();
			}
		}
	}
}
