package tk.swimmerwoad.CamelGame.entity;

import java.util.Random;

import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.level.Level;

public abstract class Entity {
	
	public int x;
	public int y;
	private boolean removed = false;
	public static Level level;
	protected final Random random = new Random();
	
	public void render(Screen screen){
		
	}
	
	public void remove(){
		removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
	}
	
	@SuppressWarnings("static-access")
	public void init(Level level){
		this.level = level;
	}

	public void update() {
		
	}
}
