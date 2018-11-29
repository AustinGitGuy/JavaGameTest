package tk.swimmerwoad.CamelGame.inventory;

public class Gold extends Item {
	
	public static int amount = 0;
	public static int sLocationX;
	public static int sLocationY;
	public static int oLocationX;
	public static int oLocationY;
	public static int slot;
	public static int width = 20;
	public static int height = 20;
	
	public Gold(){
		
	}
	
	public void update(){
		if(Gold.amount >= 1){
			if(!Inventory.slot[0] || slot == 1){
				sLocationX = 10;
				sLocationY = 50;
				oLocationX = 20;
				oLocationY = 20;
				Inventory.slot[0] = true;
				Gold.slot = 1;
			}
			else if(!Inventory.slot[1] || slot == 2){
				sLocationX = 10;
				sLocationY = 65;
				oLocationX = 25;
				oLocationY = 85;
				Inventory.slot[1] = true;
				Gold.slot = 2;
			}
			else if(!Inventory.slot[2] || slot == 3){
				sLocationX = 10;
				sLocationY = 80;
				oLocationX = 25;
				oLocationY = 150;
				Inventory.slot[2] = true;
				Gold.slot = 3;
			}
			else if(!Inventory.slot[3] || slot == 4){
				sLocationX = 10;
				sLocationY = 95;
				Inventory.slot[3] = true;
				Gold.slot = 4;
			}
			else if(!Inventory.slot[4] || slot == 5){
				sLocationX = 10;
				sLocationY = 110;
				Inventory.slot[4] = true;
				Gold.slot = 5;
			}
			else if(!Inventory.slot[5] || slot == 6){
				sLocationX = 10;
				sLocationY = 125;
				Inventory.slot[5] = true;
				Gold.slot = 6;
			}
		}
		else if(Gold.amount <= 0){
			if(slot > 0){
				Inventory.slot[slot - 1] = false;
				slot = 0;
			}
		}
	}
}
