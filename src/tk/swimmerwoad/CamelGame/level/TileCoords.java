package tk.swimmerwoad.CamelGame.level;

public class TileCoords {
	
	private int x;
	private int y;
	private final int tileSize = 16;
	
	public TileCoords (int x, int y){
		this.x = x * tileSize;
		this.y = y * tileSize;
	}
	
	public int x (){
		return x;
	}
	
	public int y (){
		return y;
	}
	
	public int [] xy (){
		int c[] = new int[2];
		c[0] = x;
		c[1] = y;
		return c;
		
	}
}
