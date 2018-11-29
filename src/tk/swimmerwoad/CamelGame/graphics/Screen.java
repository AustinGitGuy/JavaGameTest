package tk.swimmerwoad.CamelGame.graphics;

import java.util.Random;

import tk.swimmerwoad.CamelGame.entity.projectile.Projectile;

public class Screen {
	public static int width;
	public static int height;
	public final int bits = 128;
	public int xOffset;
	public int yOffset;
	public final int bitmask = bits - 1;
	public int[] pixels;
	public int[] tiles = new int[bits * bits];
	
	private Random random = new Random();
	
	@SuppressWarnings("static-access")
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for(int i = 0; i < bits * bits; i++){
			tiles[i] = random.nextInt(0xffffff); //Adds the color tiles
		}
		
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
	
	public void renderTile(int xp, int yp, Sprite sprite){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < sprite.SIZE; y++){
			int ya = y + yp;
			for(int x = 0; x < sprite.SIZE; x++){
				int xa = x + xp;
				if(xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0)xa = 0;
				pixels[xa + ya * width] = sprite.pixels[x + y * sprite.SIZE];
			}
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite, int flip){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < 32; y++){
			int ya = y + yp;
			int ys = y;
			if(flip == 2 || flip == 3) ys = 31 - y;
			for(int x = 0; x < 32; x++){
				int xa = x + xp;
				int xs = x;
				if(flip == 1 || flip == 3) xs = 31 - x;
				if(xa < -32 || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0)xa = 0;
				int color = sprite.pixels[xs + ys * 32];
				if(color != 0xffFF00FF) pixels[xa + ya * width] = color;
			}
		}
	}
	
	public void renderProjectile(int xp, int yp, Projectile p){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < p.getSpriteSize(); y++){
			int ya = y + yp;
			for(int x = 0; x < p.getSpriteSize(); x++){
				int xa = x + xp;
				if(xa < -p.getSpriteSize() || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0)xa = 0;
				int col = p.getSprite().pixels[x + y * p.getSpriteSize()];
				if (col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void renderEntity(int xp, int yp, Sprite sprite){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < 32; y++){
			int ya = y + yp;
			int ys = y;
			for(int x = 0; x < 32; x++){
				int xa = x + xp;
				int xs = x;
				if(xa < -32 || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0)xa = 0;
				int color = sprite.pixels[xs + ys * 32];
				if(color != 0xffFF00FF) pixels[xa + ya * width] = color;
			}
		}	
	}
	
	public void renderObject(int xp, int yp, Sprite sprite){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < 16; y++){
			int ya = y + yp;
			int ys = y;
			for(int x = 0; x < 16; x++){
				int xa = x + xp;
				int xs = x;
				if(xa < -32 || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0)xa = 0;
				int color = sprite.pixels[xs + ys * 16];
				if(color != 0xffFF00FF) pixels[xa + ya * width] = color;
			}
		}	
	}
	
	public void setOffset(int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

}
