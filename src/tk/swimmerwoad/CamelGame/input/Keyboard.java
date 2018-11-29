package tk.swimmerwoad.CamelGame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.Game.State;
import tk.swimmerwoad.CamelGame.entity.mob.Player;
import tk.swimmerwoad.CamelGame.level.MapCoordinates;
import tk.swimmerwoad.CamelGame.magic.CthuluSmite;

public class Keyboard implements KeyListener{
	
	private boolean[] keys = new boolean[120];
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	public boolean inv;
	public boolean menu;
	public boolean edit;
	public boolean map;
	public boolean use;
	public boolean sprint;
	public boolean magic;

	
	@SuppressWarnings("static-access")
	public void update(){
		up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
		inv = keys[KeyEvent.VK_I];
		menu = keys[KeyEvent.VK_ESCAPE];
		edit = keys[KeyEvent.VK_G];
		map = keys[KeyEvent.VK_M];
		use = keys[KeyEvent.VK_E];
		sprint = keys[KeyEvent.VK_SHIFT];
		magic = keys[KeyEvent.VK_R];
		if(edit && Game.level == Game.level.FTHouse){
			Game.state = State.Edit;
		}
		if(map && Game.level != Game.level.Map){
			Game.MapTemp = true;
		}
		if(use){
			MapCoordinates.MapEnter = true;
		}
		if(magic){
			CthuluSmite.used = true;
		}
		else {
			CthuluSmite.used = false;
		}
	}
	
	public void sprint(){
		if(sprint){
			if(Player.stamina > 0){
				Player.speed = 2;
				Player.stamina--;
			}
			
			else {
				Player.speed = 1;
			}
		}
		
		else {
				Player.speed = 1;
				Player.stamina+=.25;
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
