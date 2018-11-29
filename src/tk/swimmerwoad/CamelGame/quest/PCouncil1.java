package tk.swimmerwoad.CamelGame.quest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import tk.swimmerwoad.CamelGame.graphics.Screen;
import tk.swimmerwoad.CamelGame.input.Mouse;

public class PCouncil1 extends Quest {
	
	public String name;
	public static boolean questInit = false;
	public static boolean questPhase1 = false;
	public static boolean questPhase2 = false;
	public static boolean questPhase3 = false;
	public static boolean questDone = false;
	Font font = new Font("Arial", 0, 30);
	Font font2 = new Font("Comic Sans MS", 0, 20);

	public PCouncil1(String name) {
		super(name);
		this.name = name;
	}
	
	public static void questStart(){
		questInit = true;
		questPhase1 = true;
	}
	
	public void render(Screen screen, Graphics g, BufferStrategy bs) {
		if(questPhase1){
			g.setColor(Color.RED);
			g.setFont(font);
			g.drawString("Paris Council Start", 330, 50);
			g.setFont(font2);
			g.drawString("Hey there! The council is not in session today. I'm Councilman Patrick Bloche. "
					+ "Nice to meet you.", 10, 425);
			g.drawString("I represent the Socialist Party here, and if you don't mind the party could"
					+ "use some help.", 10, 450);
			g.setColor(Color.BLUE);
			g.drawString("Yeah I'd love to help the party!", 10, 475);
			g.drawString("Sorry I have other things to do right now.", 320, 475);
			if(Mouse.getXc() >= 10 && Mouse.getXc() <= 300){
				if(Mouse.getYc() >= 450 && Mouse.getYc() <= 475){
					Mouse.reset();
					questPhase1 = false;
					questPhase2 = true;
				}	
			}
		}
		else if(questPhase2){
			g.setColor(Color.RED);
			g.setFont(font2);
			g.drawString("Ok, I gave you some papers to deliver to my cohort in Tours. He is doing a speech to"
					+ " improve", 10, 425);
			g.drawString("his campaign. Every victory counts! Remember to press 'M' to bring up the map.", 10, 450);
			g.setColor(Color.BLUE);
			g.drawString("Thanks Mr. Bloche! Good luck.", 10, 475);
			if(Mouse.getXc() >= 10 && Mouse.getXc() <= 300){
				if(Mouse.getYc() >= 450 && Mouse.getYc() <= 475){
					questPhase2 = false;
					questPhase3 = true;
					Mouse.reset();
				}	
			}
		}
		else if(questPhase3){
			g.setColor(Color.RED);
			g.setFont(font2);
		}
	}

}
