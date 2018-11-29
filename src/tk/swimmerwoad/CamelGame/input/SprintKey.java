package tk.swimmerwoad.CamelGame.input;

import java.awt.event.KeyEvent;

public class SprintKey extends Keyboard {
	
	private boolean[] keys = new boolean[120];
	public boolean sprint;
	
	public void update(){
		sprint = keys[KeyEvent.VK_SHIFT];
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
