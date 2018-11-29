package tk.swimmerwoad.CamelGame.entity.projectile;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.entity.Entity;
import tk.swimmerwoad.CamelGame.graphics.Sprite;

public abstract class Projectile extends Entity{
	protected final int xO;
	protected final int yO;
	protected double angle;
	protected Sprite sprite;
	protected double nx;
	protected double ny;
	protected int speed;
	protected int damage;
	protected int range;
	protected double x;
	protected double y;
	protected static double sX;
	protected static double sY;
	protected double distance;
	
	public Projectile(int x, int y, double dir){
		xO = x;
		yO = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}

	public Sprite getSprite(){
		return sprite;
	}
	
	public int getSpriteSize(){
		return sprite.SIZE;
		
	}
	
	protected void move(){
		
	}

	public void update() {
		
	}
	
	public static double getX(){
		return sX;
	}
	
	public static double getY(){
		return sY;
	}
	
	private void convert(){
		sX = x;
		sY = y;
	}
	
	@SuppressWarnings("unused")
	public void run() {
		Long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int fps = 0;
		int updates = 0;
		while(Game.running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				Pupdate();
				updates++;
				delta--;
			}
			fps++;
			Pupdate();
		}
	}

	private void Pupdate() {
		convert();
	}
	
}
