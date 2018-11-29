package tk.swimmerwoad.CamelGame.house;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.Game.State;

public class HouseKey implements KeyListener {
	
	private boolean[] keys = new boolean[120];
	public boolean close;
	public boolean place;
	public boolean up;
	public boolean down;
	public boolean right;
	public boolean left;
	public boolean couch;
	public boolean chair;
	public boolean table;
	public boolean tv;

	public void update() {
		close = keys[KeyEvent.VK_R];
		place = keys[KeyEvent.VK_G];
		couch = keys[KeyEvent.VK_1];
		chair = keys[KeyEvent.VK_2];
		table = keys[KeyEvent.VK_3];
		tv = keys[KeyEvent.VK_4];
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		if(close){
			Game.state = State.Game;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}

	
}
