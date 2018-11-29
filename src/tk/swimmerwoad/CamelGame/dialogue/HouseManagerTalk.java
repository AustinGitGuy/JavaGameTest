package tk.swimmerwoad.CamelGame.dialogue;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.inventory.Gold;

public class HouseManagerTalk {
	
	public static boolean managed = true;
	public static int couch = 0;
	public static int chair = 0;
	public static int table = 1;
	public static int tv = 0;
	
	public static void StartManaging(){
		Game.box.setText("");
		Game.box.append("Hey, you there. You look like a nice guy!\n");
		Game.box.append("How would you like to own a house?\n");
		Game.box.append("NOTE: Enter your answer in the text box\n");
		Game.box.append(" ");
		Game.box.setEditable(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String[] lines = Game.box.getText().split("\n");
		String yesNo = lines[3];	
		Game.box.setEditable(false);
		if(yesNo.equals("yes") || yesNo.equals(" yes")){
				Game.box.setText("");
				Game.box.append("Ok sir! Enjoy your new house!\n");
				Game.box.append("Talk to me any time you want to renovate!\n");
				managed = true;
		}
		else if(yesNo.equals("no") || yesNo.equals(" no")){
			Game.box.setText("");
			Game.box.append("Ok, talk to me any time you want to own a house!\n");
		}
		else {
			Game.box.setText("");
			Game.box.append("I'm sorry sir, please enter yes or no.");
		}
	}
	
	public static void buy(){
		Game.box.setText("");
		Game.box.append("Hey, would you like to buy some furniture for your house?\n");
		Game.box.append("NOTE: Enter your answer in the text box\n");
		Game.box.append(" ");
		Game.box.setEditable(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String[] lines = Game.box.getText().split("\n");
		String yesNoBuy = lines[2];	
		Game.box.setEditable(false);
		if(yesNoBuy.equals("yes") || yesNoBuy.equals(" yes")){
				Game.box.setText("");
				Game.box.append("Well here is our list of furniture: \n");
				Game.box.append("Couch, table, chair, television\n");
				Game.box.append("NOTE: Please enter the furniture you want to buy in the text box\n");
				Game.box.append("If you wish to cancel enter cancel\n");
				Game.box.append(" ");
				Game.box.setEditable(true);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String[] lines1 = Game.box.getText().split("\n");
				String furniture = lines1[4];	
				Game.box.setEditable(false);
				if(furniture.equals("couch") || furniture.equals(" couch") || furniture.equals("Couch") 
						|| furniture.equals(" Couch")){
					if(Gold.amount >= 3){
						Game.box.setText("");
						Game.box.append("Enjoy your new couch! You can find it if you press 'g' in your house!\n");
						couch++;
					}
					else {
						Game.box.setText("");
						Game.box.append("I'm sorry sir you need atleast 3 gold for the couch.\n");
					}
				}
				else if(furniture.equals("chair") || furniture.equals(" chair") || furniture.equals("Chair") 
						|| furniture.equals(" Chair")){
					if(Gold.amount >= 2){
						Game.box.setText("");
						Game.box.append("Enjoy your new chair! You can find it if you press 'g' in your house!\n");
						chair++;
					}
					else {
						Game.box.setText("");
						Game.box.append("I'm sorry sir, you need atleast 2 gold for the chair.\n");
					}
				}
				else if(furniture.equals("table") || furniture.equals(" table") || furniture.equals("Table") 
						|| furniture.equals(" Table")){
					if(Gold.amount >= 2){
						Game.box.setText("");
						Game.box.append("Enjoy your new table! You can find it if you press 'g' in your house!\n");
						table++;	
					}
					else {
						Game.box.setText("");
						Game.box.append("I'm sorry sir, you need atleast 2 gold for the table.\n");
					}
				}
				else if(furniture.equals("television") || furniture.equals(" television") || 
						furniture.equals("Television") || furniture.equals(" Television") || 
						furniture.equals(" TV") || furniture.equals("TV")){
					if(Gold.amount >= 4){
						Game.box.setText("");
						Game.box.append("Enjoy your new TV! You can find it if you press 'g' in your house!\n");
						tv++;	
					}
					else {
						Game.box.setText("");
						Game.box.append("I'm sorry sir, you need atleast 4 gold for the TV.\n");
					}
				}
				else if(furniture.equals("cancel") || furniture.equals(" cancel") || furniture.equals("Cancel") 
						|| furniture.equals(" Cancel")){
					Game.box.setText("");
				}
				else {
					Game.box.setText("");
					Game.box.append("I'm sorry sir, please enter couch, table, chair or television (TV).\n");
				}
		}
		else if(yesNoBuy.equals("no") || yesNoBuy.equals(" no")){
			Game.box.setText("");
			Game.box.append("Ok, talk to me any time you want to buy some furniture!\n");
		}
		else {
			Game.box.setText("");
			Game.box.append("I'm sorry sir, please enter yes or no.");
		}
	}
	
}
