package tk.swimmerwoad.CamelGame.entity.mob;

import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.graphics.Sprite;

public class Pet extends Mob {
	
	private Sprite sprite;
	private boolean removed = false;
	public String name = "Buddy";
	public static int eX = 0;
	public static int eY = 0;
	private static int gX = (eX + 16) / 16;
	private static int gY = (eY + 16) / 16;
	
	public Pet(){
		
	}
	
	public void render(Screen screen){
		sprite = Sprite.pet;
			screen.renderEntity(x + eX, y + eY, sprite);
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
