package tk.swimmerwoad.CamelGame.entity.projectile;

import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.graphics.Sprite;

public class SlimeProjectile extends Projectile{
	
	public static final int ROF = 10;

	public SlimeProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 5;
		damage = 20;
		sprite = Sprite.SlimeWater;
		nx = Math.cos(angle) * speed;
		ny = Math.sin(angle) * speed;
	}

	public void update(){
		if(level.tilecollison(x, y, nx, ny, 12)) remove();
		move();
	}
	
	public void move(){
			x += nx;
			y += ny;	
		if(distance() > range) remove();
	}
	
	private double distance(){
		double dist = 0;
		dist = Math.sqrt(Math.abs((xO -  x) * (xO -  x) + (yO -  y) * (yO -  y)));
		return dist;
	}
	
	public void render(Screen screen){
		screen.renderProjectile((int)x - 8, (int)y - 8, this);
	}
	
	public static double getX(){
		return sX;
	}
	
	public static double getY(){
		return sY;
	}
	
	@SuppressWarnings("unused")
	private void convert(){
		sX = x;
		sY = y;
	}

}
