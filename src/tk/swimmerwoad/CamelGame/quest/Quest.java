package tk.swimmerwoad.CamelGame.quest;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import tk.swimmerwoad.CamelGame.graphics.Screen;

public abstract class Quest {
	
	public String name;
	public static boolean questInit = false;
	public static boolean questDone = false;
	
	public Quest(String name){
		super();
	}
	
	public static void questStart(){
		questRender();
	}

	private static void questRender() {
		
	}

	public void render(Screen screen, Graphics g, BufferStrategy bs) {
		
	}
}
