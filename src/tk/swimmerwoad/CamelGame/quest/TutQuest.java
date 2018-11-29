package tk.swimmerwoad.CamelGame.quest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.entity.Entity;
import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.level.Level;

public class TutQuest extends Quest{

	public String name;
	public static boolean questDone = false;
	public static boolean questPhase1 = false; //Initial Phase
	public static boolean questPhase2 = false; //Skeleton Kill Phase
	public static boolean questPhase3 = false; //Post-Skeleton Kill Phase
	
	public TutQuest(String name) {
		super(name);
		this.name = name;
	}
	
	public static void questStart(){
		questInit = true;
		questPhase1 = true;
		Game.box.setText("");
		Game.box.append("Welcome to the Tutorial Quest!\n");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Game.box.append("Use WASD to move!\n");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Game.box.append("Left Click to fire a water ball which currently has no effect, but looks cool.\n");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Game.box.append("Now let's go to the tutorial room to learn more!\n");
		Game.level = Level.TutLevel;
		Entity.level = Level.TutLevel;
		questPhase1 = false;
		questPhase2 = true;
		Game.box.append("Now let's see how good you are at defeating enemies, try to hit that skeleton over there!");
		questInit = false;
	}

	public void render(Screen screen, Graphics g, BufferStrategy bs) {
		if(questPhase1){
			g.setColor(Color.BLACK);
			Font font = new Font("Arial", Font.BOLD, 50);
			g.setFont(font);
			g.drawString("Welcome to the Tutorial Quest!", 100, 100);
			screen.clear();
			g.dispose();
			bs.show();
		}
	}

	public static void quest2() {
		Game.box.setText("");
		Game.box.append("Great! Every mob you kill gives gold and XP!\n");
		questPhase2 = false;
		questPhase3 = true;
		questInit = true;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Game.box.append("That's the basics of the game! Good luck on your adventures!");
		questInit = false;
		questDone = true;
		Game.level = Level.Start;
		Entity.level = Level.Start;
	}
}
