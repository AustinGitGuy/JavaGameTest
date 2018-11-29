package tk.swimmerwoad.CamelGame;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import tk.swimmerwoad.CamelGame.casino.CasinoMouse;
import tk.swimmerwoad.CamelGame.casino.SlotMachine;
import tk.swimmerwoad.CamelGame.crafting.Crafting;
import tk.swimmerwoad.CamelGame.entity.mob.BarGuy;
import tk.swimmerwoad.CamelGame.entity.mob.CthuluCultist;
import tk.swimmerwoad.CamelGame.entity.mob.FDR;
import tk.swimmerwoad.CamelGame.entity.mob.HouseManager;
import tk.swimmerwoad.CamelGame.entity.mob.JFK;
import tk.swimmerwoad.CamelGame.entity.mob.LHO;
import tk.swimmerwoad.CamelGame.entity.mob.LeonardNimoy;
import tk.swimmerwoad.CamelGame.entity.mob.Obama;
import tk.swimmerwoad.CamelGame.entity.mob.PCouncil;
import tk.swimmerwoad.CamelGame.entity.mob.Pet;
import tk.swimmerwoad.CamelGame.entity.mob.Player;
import tk.swimmerwoad.CamelGame.entity.mob.Skeleton;
import tk.swimmerwoad.CamelGame.entity.mob.Trotsky;
import tk.swimmerwoad.CamelGame.entity.mob.TutorialQuestGuy;
import tk.swimmerwoad.CamelGame.entity.mob.WilliamShatner;
import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.house.HouseGUI;
import tk.swimmerwoad.CamelGame.house.HouseKey;
import tk.swimmerwoad.CamelGame.house.furniture.Table;
import tk.swimmerwoad.CamelGame.input.Keyboard;
import tk.swimmerwoad.CamelGame.input.Mouse;
import tk.swimmerwoad.CamelGame.input.MouseMenu;
import tk.swimmerwoad.CamelGame.inventory.Ale;
import tk.swimmerwoad.CamelGame.inventory.CopperIngot;
import tk.swimmerwoad.CamelGame.inventory.Gold;
import tk.swimmerwoad.CamelGame.inventory.GoldIngot;
import tk.swimmerwoad.CamelGame.inventory.Inventory;
import tk.swimmerwoad.CamelGame.inventory.IronIngot;
import tk.swimmerwoad.CamelGame.inventory.RoseGold;
import tk.swimmerwoad.CamelGame.inventory.armor.WoodenHelm;
import tk.swimmerwoad.CamelGame.inventory.input.InventoryKey;
import tk.swimmerwoad.CamelGame.level.Level;
import tk.swimmerwoad.CamelGame.level.MapCoordinates;
import tk.swimmerwoad.CamelGame.level.TileCoords;
import tk.swimmerwoad.CamelGame.magic.CthuluSmite;
import tk.swimmerwoad.CamelGame.quest.PraiseCthulu;
import tk.swimmerwoad.CamelGame.quest.Quest;
import tk.swimmerwoad.CamelGame.quest.TutQuest;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	//23, 50 Tours for next quest mob
	//Todo: Add equip selection
	private Thread thread;
	private Thread thread2;
	private Thread thread3;
	private Thread thread4;
	private Thread thread5;
	private Thread thread6;
	private Thread thread7;
	
	private JFrame frame;
	private Keyboard key;
	private InventoryKey invkey;
	public static Level level;
	private Player player;
	public static boolean running = false;
	private Inventory inv;
	private Screen screen;
	private Crafting craft;
	public static String title = "CamelGame 2.0 Pre-Alpha";
	public static JTextArea box;
	private HouseGUI houseGUI;
	public static HouseKey housekey;
	
	private SlotMachine slots;
	public static CasinoMouse casinoMouse;
	
	private Skeleton skeleton;
	private CthuluCultist cc1;
	private TutorialQuestGuy tutQuestGuy;
	private BarGuy barGuy;
	private HouseManager houseMan;
	private LeonardNimoy lNimoy;
	private WilliamShatner wShatner;
	private FDR fdr;
	private Trotsky trotsky;
	private Obama obama;
	private JFK jfk;
	private LHO lho;
	
	private PCouncil pcouncil;
	
	public int xTile = (int)21;
	public int yTile = (int)21;
	public static boolean MapTemp;
	
	public Quest TutQuest = new TutQuest("Tutorial");
	public Quest PraiseC = new PraiseCthulu("Praise Cthulu");
	public Quest PCouncil1 = new tk.swimmerwoad.CamelGame.quest.PCouncil1("Parisian Council Start");

	private Pet pet;
	private Table table;
	
	private Gold gold;
	private Ale ale;
	private IronIngot iron;
	private GoldIngot goldI;
	private CopperIngot copper;
	private RoseGold roseG;
	
	private WoodenHelm woodH;
	
	private CthuluSmite csmite;
	
	public static State state = State.Game;
	private Menu menu = new Menu();
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public Game(){
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		invkey = new InventoryKey();
		housekey = new HouseKey();
		inv = new Inventory();
		craft = new Crafting();
		houseGUI = new HouseGUI();
		
		level = Level.PP;
		
		TileCoords spawn = new TileCoords(xTile, yTile);
		player = new Player(spawn.x(), spawn.y(), key);
		player.init(level);
		
		skeleton = new Skeleton();
		cc1 = new CthuluCultist();
		tutQuestGuy = new TutorialQuestGuy();
		barGuy = new BarGuy();
		houseMan = new HouseManager();
		lNimoy = new LeonardNimoy();
		fdr = new FDR();
		wShatner = new WilliamShatner();
		trotsky = new Trotsky();
		obama = new Obama();
		jfk = new JFK();
		lho = new LHO();
		
		pcouncil = new PCouncil();
		
		csmite = new CthuluSmite();
		
		slots = new SlotMachine();
		
		pet = new Pet();
		table = new Table();
		
		roseG = new RoseGold();
		gold = new Gold();
		iron = new IronIngot();
		goldI = new GoldIngot();
		copper = new CopperIngot();
		ale = new Ale();
		
		woodH = new WoodenHelm();
		
		addKeyListener(key);
		addKeyListener(invkey);
		addKeyListener(housekey);
		
		Mouse mouse = new Mouse();
		casinoMouse = new CasinoMouse();
		MouseMenu mouseM = new MouseMenu();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		addMouseListener(mouseM);
		addMouseListener(casinoMouse);
		
		box = new JTextArea(5, 5);
		box.setEditable(false);
	}
	
	public static enum State{
		Menu, Game, Exit, Inventory, Edit, Casino;
	};
	
	public synchronized void start() {
		thread = new Thread(this, "Display");
		thread2 = new Thread(new Thread2()); //Respawning
		thread3 = new Thread(new Thread3()); //XP Calculation and Leveling
		thread4 = new Thread(new Thread4()); //Skills Calculation
		thread5 = new Thread(new Thread5()); //Currently dead
		thread6 = new Thread(new Thread6()); //Sprinting
		thread7 = new Thread(new Thread7()); //Casino Stuff
		thread.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		running = true;
	}
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		Long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int fps = 0;
		int updates = 0;
		requestFocus();
		while(running){
			if(state == State.Exit){
				stop();
			}
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				while(delta >= 1){
					update();
					render();
					updates++;
					delta--;
				}
				fps++;
				
				if(System.currentTimeMillis() - timer > 1000){
					timer += 1000;
					frame.setTitle(title + "   |   " + updates + " ups, " + fps + " fps");
					updates = 0;
					fps = 0;
				}
		}
		stop();
	}
	
	public void update(){
		if(!Quest.questInit && state == State.Game){
			key.update();
			player.update();
			level.update();
			Level.time();
			ale.update();
			iron.update();
			goldI.update();
			copper.update();
			roseG.update();
			gold.update();
			key.sprint();
			woodH.update();
		}
		else if(state == State.Inventory){
			invkey.update();
			inv.update();
			craft.update();
		}
		else if(state == State.Edit){
			housekey.update();
			houseGUI.update();
		}
	}
	
	public static int getWindowWidth(){
		return width * scale;
	}
	
	public static int getWindowHeight(){
		return height * scale;
	}
	
	@SuppressWarnings("static-access")
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		if(table.tableCount >= 1){
			table.render(screen);
		}
		Graphics g = bs.getDrawGraphics();
		if(state == State.Inventory){
			inv.render(g);
			craft.render(g, screen);
			//Inventory.goldInt ++; - Caused a bug
			//Bug Report: Infinite amount of gold can be generated - Solved
		}
		else if(state == State.Edit){
			houseGUI.render(g);
		}
		else if(state == State.Game){
			int xScroll = player.x - screen.width / 2;
			int yScroll = player.y - screen.height / 2;;
			level.render(xScroll, yScroll, screen);
			player.render(screen);
			
			skeleton.render(screen);
			cc1.render(screen);
			tutQuestGuy.render(screen);
			barGuy.render(screen);
			houseMan.render(screen);
			lNimoy.render(screen);
			fdr.render(screen);
			wShatner.render(screen);
			trotsky.render(screen);
			obama.render(screen);
			jfk.render(screen);
			lho.render(screen);
			
			pcouncil.render(screen);
			
			pet.render(screen);
			for(int i = 0; i < pixels.length; i++){
				pixels[i] = screen.pixels[i];
			}
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
			g.setColor(Color.RED);
			g.setFont(new Font("Comic Sans MS", 0, 20));
			g.drawString("Level: " + Player.pLevel, 50, 50);
			g.drawString("X: " + player.x / 16, 50, 80);
			g.drawString("Y: " + player.y / 16, 50, 100);
			g.setColor(Color.BLACK);
			if(!pet.isRemoved()){
				//g.drawString(pet.name, (Pet.getX() * 16) - 16, (Pet.getY() * 16) - 16);
			}
			TutQuest.render(screen, g, bs);
			PCouncil1.render(screen, g, bs);
			PraiseC.render(screen, g, bs);
			csmite.render(screen, g);
			if(MapCoordinates.Paris){
				g.setColor(Color.BLACK);
				g.drawString("This is Paris, France.", 350, 50);
				g.setColor(Color.RED);
			}
			if(MapCoordinates.Tours){
				g.setColor(Color.BLACK);
				g.drawString("This is Tours, France.", 350, 50);
				g.setColor(Color.RED);
			}
			renderTitle(g);
		}
		else if(state == State.Casino){
			slots.render(screen, g ,bs); //Bug Report: DRIVING ME INSANE
		}
		else if(state == State.Menu){
			menu.render(screen, g);
		}
		g.dispose();
		screen.clear();
		bs.show();
	}
	
	public void renderTitle(Graphics g){
		if(MapCoordinates.PAirport){
			g.setColor(Color.WHITE);
			g.drawString("This the Parisian International Airport", 130, 50);
		}
		if(MapCoordinates.PCthulu){
			g.setColor(Color.WHITE);
			g.drawString("This is a run-down shack", 130, 50);
		}
		if(MapCoordinates.PHouse){
			g.setColor(Color.WHITE);
			g.drawString("This is your home", 130, 50);
		}
		if(MapCoordinates.PP){
			g.setColor(Color.WHITE);
			g.drawString("This is the Ministry of Foreign Affairs", 130, 50);
		}
		if(MapCoordinates.PCards){
			g.setColor(Color.WHITE);
			g.drawString("This is the Casino", 130, 50);
		}
		if(MapCoordinates.Victory){
			g.setColor(Color.WHITE);
			g.drawString("This Place de la Victoire, Victory Square", 130, 50);
		}
		g.setColor(Color.RED);
	}
	
	public static void main(String[] args){
		Game game = new Game();
		game.frame.setResizable(true);
		game.frame.setTitle(Game.title);
		game.frame.add(box, BorderLayout.PAGE_END);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();
	}
}
