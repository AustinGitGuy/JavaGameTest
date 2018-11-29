package tk.swimmerwoad.CamelGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import tk.swimmerwoad.CamelGame.graphics.Screen;

public class Menu {
	
	public Rectangle play = new Rectangle(350, 150, 200, 100);
	public Rectangle exit = new Rectangle(350, 350, 200, 100);
	
	public void render (Screen screen, Graphics g){
		g.setColor(Color.WHITE);
		g.drawRect(0, 0, Game.getWindowWidth(), Game.getWindowHeight());
		Graphics2D g2d = (Graphics2D) g;
		Font font = new Font("Arial", Font.BOLD, 50);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("Menu for CamelGame", 200, 100);
		g.drawString("Play", play.x + 50, play.y + 65);
		g.drawString("Exit", exit.x + 50, exit.y + 65);
		g2d.draw(play);
		g2d.draw(exit);
	}
}
