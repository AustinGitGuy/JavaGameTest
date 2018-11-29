package tk.swimmerwoad.CamelGame.dialogue;

import tk.swimmerwoad.CamelGame.Game;
import tk.swimmerwoad.CamelGame.inventory.Ale;
import tk.swimmerwoad.CamelGame.inventory.Gold;

public class BarGuyTalk {
	
	public static void buyDrink() {
		Game.box.setText("");
		Game.box.append("What would you like to buy?\n");
		Game.box.append("We currently only have ale, want to buy some?\n");
		Game.box.append("NOTE: Enter your answer in the text box.\n");
		Game.box.append(" ");
		Game.box.setEditable(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String[] lines = Game.box.getText().split("\n");
		String yesNo = lines[3]; //Bug: Always displays invalid answer. SOLVED: Using wrong if/else.		
		Game.box.setEditable(false);
		if(yesNo.equals("yes") || yesNo.equals(" yes")){
			if(Gold.amount >= 1){
				Game.box.setText("");
				Game.box.append("Ok here is your ale!\n");
				Ale.amount += 1;	
			}
			else {
				Game.box.setText("");
				Game.box.append("I'm sorry sir you do not have enought money!");
			}
		}
		else if(yesNo.equals("no") || yesNo.equals(" no")){
			Game.box.setText("");
			Game.box.append("Ok have a nice day!\n");
		}
		else {
			Game.box.setText("");
			Game.box.append("I'm sorry sir, please enter yes or no.");
		}
	}
	
}
