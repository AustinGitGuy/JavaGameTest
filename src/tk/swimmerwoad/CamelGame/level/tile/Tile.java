package tk.swimmerwoad.CamelGame.level.tile;

import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.graphics.Sprite;

public class Tile {
	
	public int x;
	public int y;
	
	public Sprite sprite;
	
	public static Tile grassTile = new GrassTile(Sprite.grass);
	public static Tile flowerTile = new FlowerTile(Sprite.flower);
	public static Tile grassRockTile = new GrassRockTile(Sprite.grassRock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile stoneTile = new StoneTile(Sprite.stoneSprite);
	public static Tile waterTile = new WaterTile(Sprite.waterSprite);
	public static Tile spawnWall = new SpawnWall(Sprite.wallFront);
	public static Tile spawnRoof = new SpawnRoof(Sprite.spawnRoof);
	public static Tile spawnFloor = new SpawnFloor(Sprite.spawnFloor);
	public static Tile street = new Street(Sprite.street);
	public static Tile cthuluShrine = new CthuluShrine(Sprite.cthuluShrine);
	public static Tile balloon = new Balloon(Sprite.balloon);
	public static Tile cakeTable = new CakeTable(Sprite.cakeTable);
	public static Tile slots = new Slots(Sprite.slots);
	public static Tile chairt1 = new Chairt1(Sprite.chairt1);
	public static Tile chairt2 = new Chairt2(Sprite.chairt2);
	public static Tile chairt3 = new Chairt3(Sprite.chairt3);
	public static Tile chairt4 = new Chairt4(Sprite.chairt4);
	
	public static final int grassColor = 0xff00ff00;
	public static final int grassColor2 = 0xffffffff;
	public static final int flowerColor = 0xffffff00;
	public static final int grassRockColor = 0xff7f7f00;
	public static final int waterColor = 0xff0000ff;
	public static final int waterColor2 = 0xffb6dcf4;
	public static final int stoneColor = 0xff8f8f8f;
	public static final int spawnWallColor = 0xff6f4e37;
	public static final int spawnRoofColor = 0xff38281c;
	public static final int voidColor = 0xff000000;
	public static final int streetColor = 0xffcdcdcd;
	public static final int floorColor = 0xffdfdfdf;
	public static final int cthuluColor = 0xff65bd43;
	public static final int balloonColor = 0xffff0000;
	public static final int cakeColor = 0xffff8000;
	public static final int slotsColor = 0xffb75a00;
	public static final int chairt1c = 0xffca1111;
	public static final int chairt2c = 0xffca2222;
	public static final int chairt3c = 0xffca3333;
	public static final int chairt4c = 0xffca4444;
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}
	
	public boolean boat(){
		return false;
	}
}
