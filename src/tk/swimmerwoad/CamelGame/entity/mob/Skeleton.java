package tk.swimmerwoad.CamelGame.entity.mob;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.Thread2;
import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.graphics.Sprite;
import tk.swimmerwoad.CamelGame.inventory.Gold;
import tk.swimmerwoad.CamelGame.level.Level;

public class Skeleton extends Mob {
	
	private Sprite sprite;
	private boolean removed = false;
	private static int eX = 32;
	private static int eY = 32;
	private static double gX = (eX + 16) / 16;
	private static double gY = (eY + 16) / 16;
	public static boolean dead = false;
	
	public Skeleton(){
		
	}
	
	public void render(Screen screen){
		sprite = Sprite.skeleton;
		if(!dead){
			if(Game.level == Level.Start || Game.level == Level.TutLevel){
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
	
	public static double getX(){
		return gX;
	}
	
	public static double getY(){
		return gY;
	}
	
	public static void dies(){
		
	}
	
	public static void respawn(){
		try {
				Gold.amount += 1;
				Player.pXp += 2;
				Thread2.sleep(2000);
				dead = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
