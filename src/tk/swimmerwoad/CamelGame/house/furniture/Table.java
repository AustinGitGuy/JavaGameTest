package tk.swimmerwoad.CamelGame.house.furniture;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.entity.mob.Mob;
import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.graphics.Sprite;
import tk.swimmerwoad.CamelGame.level.Level;

public class Table extends Mob {
	
	public static int tableCount = 0;
	private Sprite sprite = Sprite.table;
	public static int t1x = 32;
	public static int t1y = 32;
	public static int t2x = 16;
	public static int t2y = 16;
	public static int t3x = 16;
	public static int t3y = 16;

	public void render(Screen screen){
			if(Game.level == Level.FTHouse && tableCount >= 1){
				System.out.println("Test");
				screen.renderEntity(x + t1x, y + t1y, sprite);
		}
			if(Game.level == Level.FTHouse && tableCount >= 2){
				screen.renderObject(x + t2x, y + t2y, sprite);
		}
	}
}
