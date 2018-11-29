package tk.swimmerwoad.CamelGame.casino;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.Game.State;
import tk.swimmerwoad.CamelGame.graphics.Screen;

public class SlotMachine {
	
	public static boolean enter;
	public static boolean main;
	public static boolean slotsE;
	public static boolean temp;
	public static boolean slotsS;
	private Font font = new Font("Arial", Font.BOLD, 50);
	private Font font2 = new Font("Comic Sans MS", 0, 20);
	public static BufferedImage cherry;
	public static BufferedImage strawberry;
	public static BufferedImage bar;
	public static BufferedImage seven;
	private Random rand = new Random();
	private BufferedImage img, img2, img3, img4, img5, img6, img7, img8, img9;
	private int[] i = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	public static Rectangle slots = new Rectangle(350, 50, 200, 100);
	public static Rectangle exit = new Rectangle(350, 250, 200, 100);
	public static Rectangle slotRect = new Rectangle(150, 50, 540, 400);
	
	public SlotMachine(){
		try {
			cherry = ImageIO.read(new File("./res/casino/cherry.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			strawberry = ImageIO.read(new File("./res/casino/strawberry.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			seven = ImageIO.read(new File("./res/casino/seven.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bar = ImageIO.read(new File("./res/casino/bar.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		img = cherry;
		img2 = cherry;
		img3 = cherry;
		img4 = cherry;
		img5 = cherry;
		img6 = cherry;
		img7 = cherry;
		img8 = cherry;
		img9 = cherry;
	}
	
	public void update(){
		if(enter){
			Game.state = State.Casino;
			main = true;
			if(CasinoMouse.getX() >= slots.x && CasinoMouse.getX() <= slots.x + slots.width){
				if(CasinoMouse.getY() >= slots.y && CasinoMouse.getY() <= slots.y + slots.height){
					enter = false;
					main = false;
					slotsE = true;
				}
			}
			
			if(CasinoMouse.getX() >= exit.x && CasinoMouse.getX() <= exit.x + exit.width){
				if(CasinoMouse.getY() >= exit.y && CasinoMouse.getY() <= exit.y + exit.height){
					main = false;
					enter = false;
					temp = true;
					Game.state = State.Game;
					CasinoMouse.mouseX = -1;
					CasinoMouse.mouseY = -1;
				}
			}
		}
		else if(slotsE){
			if(CasinoMouse.getX() >= 700 && CasinoMouse.getX() <= 800){
				if(CasinoMouse.getY() >= 100 && CasinoMouse.getY() <= 200){
					slotsE = false;
					slotsS = true;
				}
			}
		}
		slotUpdate();
		if(temp){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			temp = false;
		}
	}

	public void render(Screen screen, Graphics g, BufferStrategy bs) {
		Graphics2D g2d = (Graphics2D) g;
		if(main){
			g.setColor(Color.WHITE);
			g.setFont(font);
			g.fillRect(0, 0, Game.getWindowWidth(), Game.getWindowHeight());
			g.setColor(Color.BLACK);
			g2d.draw(slots);
			g.drawString("Slots", 390, 117);
			g2d.draw(exit);
			g.drawString("Exit", 390, 317);
		}
		if(slotsE || slotsS){
			g.setColor(Color.WHITE);
			g.setFont(font);
			g.fillRect(0, 0, Game.getWindowWidth(), Game.getWindowHeight());
			//First Column
			g.drawImage(img, slotRect.x + 1, slotRect.y + 3, null);
			g.drawImage(img2, slotRect.x + 1, slotRect.y + 135, null);
			g.drawImage(img3, slotRect.x + 1, slotRect.y + 267, null);
			//Second Column
			g.drawImage(img4, slotRect.x + 181, slotRect.y + 3, null);
			g.drawImage(img5, slotRect.x + 181, slotRect.y + 135, null);
			g.drawImage(img6, slotRect.x + 181, slotRect.y + 267, null);
			//Third Column
			g.drawImage(img7, slotRect.x + 361, slotRect.y + 3, null);
			g.drawImage(img8, slotRect.x + 361, slotRect.y + 135, null);
			g.drawImage(img9, slotRect.x + 361, slotRect.y + 267, null);
			g.setColor(Color.BLACK);
			//Slot Rectangle
			g2d.draw(slotRect);
			//Start Lever
			g.setFont(font2);
			g.drawString("Pull to start", 700, 90);
			g.setColor(Color.GRAY);
			g.fillOval(700, 100, 100, 100);
			//Coin Receptacle
			g.fillRect(700, 400, 100, 30);
			g.setColor(Color.BLACK);
			g.fillRect(705, 405, 90, 20);
		}
		screen.clear();
		g.dispose();
		bs.show();
	}
	
	public void slotUpdate(){
		if(slotsS){
			i[0] = rand.nextInt((4 - 1) + 1) + 1;
			slotImg(i[0], 0);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			i[1] = rand.nextInt((4 - 1) + 1) + 1;
			slotImg(i[1], 1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			i[2] = rand.nextInt((4 - 1) + 1) + 1;
			slotImg(i[2], 2);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			i[3] = rand.nextInt((4 - 1) + 1) + 1;
			slotImg(i[3], 3);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			i[4] = rand.nextInt((4 - 1) + 1) + 1;
			slotImg(i[4], 4);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			i[5] = rand.nextInt((4 - 1) + 1) + 1;
			slotImg(i[5], 5);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			i[6] = rand.nextInt((4 - 1) + 1) + 1;
			slotImg(i[6], 6);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			i[7] = rand.nextInt((4 - 1) + 1) + 1;
			slotImg(i[7], 7);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			i[8] = rand.nextInt((4 - 1) + 1) + 1;
			slotImg(i[8], 8);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void slotImg(int i, int index){
		BufferedImage temp = null;;
		if(i == 1){
			try {
				temp = ImageIO.read(new File("./res/casino/cherry.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(i == 2){
			try {
				temp = ImageIO.read(new File("./res/casino/strawberry.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(i == 3){
			try {
				temp = ImageIO.read(new File("./res/casino/bar.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(i == 4){
			try {
				temp = ImageIO.read(new File("./res/casino/seven.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(index == 1){
			img = temp;
		}
		if(index == 2){
			img2 = temp;
		}
		if(index == 3){
			img3 = temp;
		}
		if(index == 4){
			img4 = temp;
		}
		if(index == 5){
			img5 = temp;
		}
		if(index == 6){
			img6 = temp;
		}
		if(index == 7){
			img7 = temp;
		}
		if(index == 8){
			img8 = temp;
		}
		if(index == 9){
			img9 = temp;
		}
	}
}