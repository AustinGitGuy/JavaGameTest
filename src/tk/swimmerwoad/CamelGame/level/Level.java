package tk.swimmerwoad.CamelGame.level;

import java.util.ArrayList;
import java.util.List;

import tk.swimmerwoad.CamelGame.entity.Entity;
import tk.swimmerwoad.CamelGame.entity.projectile.Projectile;
import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.level.tile.Tile;

public class Level {
	
	protected int width;
	protected int height;
	protected int[] tilesInt;
	public int borderLength = 5;
	protected int[] tiles;
	protected int[] entity;
	public static Level Start = new StartingLevel("/textures/level.png");
	public static Level FirstTown = new FirstTown("/textures/first_town.png");
	public static Level TutLevel = new TutLevel("/textures/tut_level.png");
	public static Level FTTavern = new FTTavern("/textures/fttavern.png");
	public static Level FTCasino = new FTCasino("/textures/ftcasino.png");
	public static Level FTHouse = new FTHouse("/textures/fthouse.png");
	public static Level Map = new Map("/textures/paris.png");
	public static Level Paris = new Paris("/textures/paris.png");
	public static Level PHouse = new PHouse("/textures/phouse.png");
	public static Level PCthulu = new PCthulu("/textures/pcthulu.png");
	public static Level PCards = new PCards("/textures/pcards.png");
	public static Level PP = new PP("/textures/pp.png");
	public static Level Tours = new Tours("/textures/tours.png");
	public static long time;
	
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}
	
	public Level(String path){
		loadLevel(path);
		generateLevel();
	}
	
	protected void generateLevel(){
		
	}
	
	protected void loadLevel(String path){
		
	}
	
	public void update(){
		for(int i =0; i < entities.size(); i++){
			entities.get(i).update();
		}
		for(int i =0; i < projectiles.size(); i++){
			projectiles.get(i).update();
		}
	}
	
	public List<Projectile> getProjctiles(){
		return projectiles;
	}
	
	public boolean tilecollison(double x, double y, double nx, double ny, int size){
		boolean solid = false;
		for (int c = 0; c  < 4; c++){
			int xt = (((int)x + (int)nx) + c % 2 * size / 10 + 1) / 16;
			int yt = (((int)y + (int)ny) + c / 2 * size / 10) / 16;
			if (getTile(xt, yt).solid()) solid = true;
		}
		return solid;
	}
	
	public static void time(){
		time = System.currentTimeMillis();
	}
	
	@SuppressWarnings("static-access")
	public void render(int xScroll, int yScroll, Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4; // >> 4 = 2x2x2x2 = 16
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		for(int y = y0; y < y1; y++){
			for(int x = x0; x < x1; x++){
				getTile(x, y).render(x, y, screen);
			}
		}
		for(int i =0; i < entities.size(); i++){
			entities.get(i).render(screen);
		}
		for(int i =0; i < projectiles.size(); i++){
			projectiles.get(i).render(screen);
		}
	}
	
	public void add(Entity e){
		entities.add(e);
	}
	
	public void addProjectile(Projectile p){
		projectiles.add(p);
		p.init(this);
	}
	
	public Tile getTile(int x, int y){
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == Tile.grassColor) return Tile.grassTile;
		if (tiles[x + y * width] == Tile.grassColor2) return Tile.grassTile;
		if (tiles[x + y * width] == Tile.stoneColor) return Tile.stoneTile;
		if (tiles[x + y * width] == Tile.flowerColor) return Tile.flowerTile;
		if (tiles[x + y * width] == Tile.grassRockColor) return Tile.grassRockTile;
		if (tiles[x + y * width] == Tile.waterColor) return Tile.waterTile;
		if (tiles[x + y * width] == Tile.waterColor2) return Tile.waterTile;
		if (tiles[x + y * width] == Tile.spawnWallColor) return Tile.spawnWall;
		if (tiles[x + y * width] == Tile.spawnRoofColor) return Tile.spawnRoof;
		if (tiles[x + y * width] == Tile.streetColor) return Tile.street;
		if (tiles[x + y * width] == Tile.floorColor) return Tile.spawnFloor;
		if (tiles[x + y * width] == Tile.cthuluColor) return Tile.cthuluShrine;
		if (tiles[x + y * width] == Tile.balloonColor) return Tile.balloon;
		if (tiles[x + y * width] == Tile.cakeColor) return Tile.cakeTable;
		if (tiles[x + y * width] == Tile.slotsColor) return Tile.slots;
		if (tiles[x + y * width] == Tile.chairt1c) return Tile.chairt1;
		if (tiles[x + y * width] == Tile.chairt2c) return Tile.chairt2;
		if (tiles[x + y * width] == Tile.chairt3c) return Tile.chairt3;
		if (tiles[x + y * width] == Tile.chairt4c) return Tile.chairt4;
		if (tiles[x + y * width] == Tile.voidColor) return Tile.voidTile;
		return Tile.voidTile;
		
	}
	
	public Entity getEntity(int x, int y){
		return null;
	}

	public double getWidth() {
		return 0;
	}

	public double getHeight() {
		return 0;
	}
}
