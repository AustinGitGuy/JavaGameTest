package tk.swimmerwoad.CamelGame.entity.mob;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.Game.State;
import tk.swimmerwoad.CamelGame.casino.SlotMachine;
import tk.swimmerwoad.CamelGame.entity.projectile.Projectile;
import tk.swimmerwoad.CamelGame.entity.projectile.SlimeProjectile;
import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.graphics.Sprite;
import tk.swimmerwoad.CamelGame.input.Keyboard;
import tk.swimmerwoad.CamelGame.input.Mouse;
import tk.swimmerwoad.CamelGame.level.Level;
import tk.swimmerwoad.CamelGame.level.MapCoordinates;

public class Player extends Mob {
	
	private Keyboard input;
	private Sprite sprite;
	int flip = 0;
	private int a = 0;
	boolean moving = false;
	public static int pLevel = 1;
	public static double pXp = 0;
	private int rof = 0;
	public static float stamina = 500;
	public static float speed = 1;
	public static float tempSpeed = 1;
	public static float MoveStat = 0;
	public static int MoveLevel = 1;
	public static float BashStat = 0;
	public static int BashLevel = 1;
	public static float VigStat = 0;
	public static int VigLevel = 1;
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.playerFront;
		rof = SlimeProjectile.ROF;
	}
	
	public Player(Keyboard input){
		this.input = input;
		sprite = Sprite.playerFront;
	}
	
	public void update(){
		if(SlotMachine.temp){
			SlotMachine.temp = false;
		}
		if(rof > 0) rof--;
		int xa = 0;
		int ya = 0;
		if(a >= 7500) a = 0;
		else a++;
		if(input.up){
			ya-=speed;
			MoveStat+= .10;
		}
		if(input.down){
			ya+=speed;
			MoveStat+= .10;
		}
		if(input.left){
			xa-=speed;
			MoveStat+= .10;
		}
		if(input.right){
			xa+=speed;
			MoveStat+= .10;
		}
		if(input.menu) Game.state = State.Menu;
		if(input.inv){
			if(Game.state == State.Game) Game.state = State.Inventory;
		}
		if(xa != 0 || ya != 0){
			move(xa, ya);
			walking = true;
		}
		else{
			walking = false;
		}
		clear();
		updateShooting();
		if(input.up){
			Pet.eX = x - 16;
			Pet.eY = y + 10;
		}
		if(input.down){
			Pet.eX = x - 16;
			Pet.eY = y - 40;
		}
		if(input.left){
			Pet.eX = x + 8;
			Pet.eY = y - 16;
		}
		if(input.right){
			Pet.eX = x - 40;
			Pet.eY = y - 16;
		}
		if(Game.MapTemp){
			if(level == Level.Paris || level == Level.PP){
				Game.level = Level.Map;
				level = Level.Map;
				x = ((int) MapCoordinates.Parisx * 16);
				y = ((int) MapCoordinates.Parisy * 16) - 16;
				Game.MapTemp = false;
			}
			else {
				Game.MapTemp = false;
			}
		}
		collision(xa, ya);
	}
	
	private void clear() {
		for(int i = 0; i < level.getProjctiles().size(); i++){
			Projectile p = level.getProjctiles().get(i);
			if(p.isRemoved()) level.getProjctiles().remove(i);
		}
	}

	private void updateShooting() {
		if(Mouse.getButton() == 1 && rof <= 0){
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
			rof = SlimeProjectile.ROF;
			}
		}

	public void render(Screen screen){
		if(dir == 0){
			sprite = Sprite.playerBack;
			if(walking){
				if(a % 20 > 10) sprite = Sprite.playerBackA;
			}
		}
		if(dir == 1 || dir == 3){
			sprite = Sprite.playerSide;
			if(dir == 3) flip = 1;
			if(dir == 1) flip = 0;
			if(walking){
				if(a % 20 > 10) sprite = Sprite.playerSideA;
			}
		}
		if(dir == 2){
			sprite = Sprite.playerFront;
			if(walking){
				if(a % 20 > 10) sprite = Sprite.playerFrontA;
			}
		}
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}
	
	public void shoot(int x, int y, double dir){
		Projectile p1 = new SlimeProjectile(x, y, dir);
		level.addProjectile(p1);
	}
	
}
