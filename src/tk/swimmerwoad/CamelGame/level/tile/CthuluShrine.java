package tk.swimmerwoad.CamelGame.level.tile;

import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.graphics.Sprite;

public class CthuluShrine extends Tile {
	public CthuluShrine(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, Sprite.cthuluShrine);
	}
	
	public boolean solid(){
		return true;
	}

}
