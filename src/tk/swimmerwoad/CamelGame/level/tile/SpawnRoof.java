package tk.swimmerwoad.CamelGame.level.tile;

import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.graphics.Sprite;

public class SpawnRoof extends Tile {
	public SpawnRoof(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, Sprite.spawnRoof);
	}
	
	public boolean solid(){
		return true;
	}
}
