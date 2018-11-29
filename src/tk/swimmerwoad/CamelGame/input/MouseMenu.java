package tk.swimmerwoad.CamelGame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.Game.State;

public class MouseMenu implements MouseListener, MouseMotionListener {
	
	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		/**
		 * play = new Rectangle(350, 150, 200, 100);
		 * exit = new Rectangle(350, 350, 200, 100);
		 */
		
		int mx = e.getX();
		int my = e.getY();
		
		if(mx >= 350 && mx <= 550 && Game.state == State.Menu){
			if(my >= 150 && my <= 250){
				Game.state = State.Game;
			}
			else if(my >= 350 && my <= 450 && Game.state == State.Menu){
				System.exit(1);
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		
	}

}
