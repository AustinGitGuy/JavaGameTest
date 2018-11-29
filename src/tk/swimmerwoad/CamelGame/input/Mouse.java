package tk.swimmerwoad.CamelGame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.Game.State;
import tk.swimmerwoad.CamelGame.inventory.Inventory;
import tk.swimmerwoad.CamelGame.quest.PraiseCthulu;

public class Mouse implements MouseListener, MouseMotionListener  {
	
	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;
	private static int mouseXc = -1;
	private static int mouseYc = -1;
	
	public static void reset(){
		mouseXc = -1;
		mouseYc = -1;
	}
	
	public static int getX(){
		return mouseX;
	}
	
	public static int getY(){
		return mouseY;
	}
	
	public static int getXc(){
		return mouseXc;
	}
	
	public static int getYc(){
		return mouseYc;
	}
	
	public static int getButton(){
		return mouseB;
	}
	
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseClicked(MouseEvent e) {
		mouseXc = e.getX();
		mouseYc = e.getY();
		if(PraiseCthulu.questPhase1){
			if(mouseXc >= 300 && mouseXc <= 330){
				if(mouseYc >= 460 && mouseYc <= 490){
					PraiseCthulu.questy = true;
					PraiseCthulu.questPhase1 = false;
					PraiseCthulu.questPhase2 = true;
				}
			}
			
			else if(mouseXc >= 550 && mouseXc <= 580){
				if(mouseYc >= 460 && mouseYc <= 490){
					PraiseCthulu.questn = true;
					PraiseCthulu.questPhase1 = false;
					PraiseCthulu.questPhase2 = true;
				}
			}
		}
		
		else if(PraiseCthulu.questPhase2){
			if(mouseXc >= 350 && mouseXc <= 530){
				if(mouseYc >= 460 && mouseYc <= 490){
					if(PraiseCthulu.questy){
						PraiseCthulu.questDone = true;
						PraiseCthulu.questPhase2 = false;
						PraiseCthulu.questInit = false;
					}
					
					else if(PraiseCthulu.questn){
						PraiseCthulu.questAlt = true;
						PraiseCthulu.questPhase2 = false;
						PraiseCthulu.questInit = false;
					}
				}
			}
		}
		
		if(Game.state == State.Inventory){
			if(mouseXc >= 215 && mouseXc <= 245){
				if(mouseYc <= 25 && mouseYc >= 8){
					Inventory.items = true;
					Inventory.armor = false;
					Inventory.crafting = false;
				}
			}
			else if(mouseXc >= 269 && mouseXc <= 300){
				if(mouseYc <= 25 && mouseYc >= 8){
					Inventory.items = false;
					Inventory.armor = true;	
					Inventory.crafting = false;
				}
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		mouseB = e.getButton();
	}

	public void mouseReleased(MouseEvent e) {
		mouseB = -1;
		mouseXc = -1;
		mouseYc = -1;
		mouseX = -1;
		mouseY = -1;
	}

}
