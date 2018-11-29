package tk.swimmerwoad.CamelGame.entity.mob;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.graphics.Sprite;
import tk.swimmerwoad.CamelGame.level.Level;

public class HouseManager extends Mob {
	
	private Sprite sprite;
	private boolean removed = false;
	private static int eX = 752;
	private static int eY = 240;
	private static int gX = (eX + 16) / 16;
	private static int gY = (eY + 16) / 16;
	public static boolean dead = false;
	
	public HouseManager(){
		
	}
	
	public void render(Screen screen){
		sprite = Sprite.barGuy;
		if(!dead){
			if(Game.level == Level.FirstTown){
			screen.renderEntity(x + eX, y + eY, sprite);
			}
		}
	}
	
	public void removed(){
		removed = false;
	}
	
	public boolean isRemoved(){
		return removed;
		
	}
	
	public boolean solid(){
		return true;
	}
	
	public static int getX(){
		return gX;
	}
	
	public static int getY(){
		return gY;
	}
}
