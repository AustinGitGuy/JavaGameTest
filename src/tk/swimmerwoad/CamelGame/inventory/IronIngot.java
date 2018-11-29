package tk.swimmerwoad.CamelGame.inventory;

public class IronIngot extends Item {
	
	public static int amount = 0;
	public static int sLocationX;
	public static int sLocationY;
	public static int oLocationX;
	public static int oLocationY;
	public static int slot;
	public static int width = 20;
	public static int height = 20;
	
	public IronIngot(){
		
	}
	
	public void update(){
		if(IronIngot.amount >= 1){
			if(!Inventory.slot[0] || slot == 1){
				sLocationX = 10;
				sLocationY = 50;
				oLocationX = 20;
				oLocationY = 20;
				Inventory.slot[0] = true;
				IronIngot.slot = 1;
			}
			else if(!Inventory.slot[1] || slot == 2){
				sLocationX = 10;
				sLocationY = 65;
				oLocationX = 25;
				oLocationY = 85;
				Inventory.slot[1] = true;
				IronIngot.slot = 2;
			}
			else if(!Inventory.slot[2] || slot == 3){
				sLocationX = 10;
				sLocationY = 80;
				oLocationX = 25;
				oLocationY = 150;
				Inventory.slot[2] = true;
				IronIngot.slot = 3;
			}
			else if(!Inventory.slot[3] || slot == 4){
				sLocationX = 10;
				sLocationY = 95;
				Inventory.slot[3] = true;
				IronIngot.slot = 4;
			}
			else if(!Inventory.slot[4] || slot == 5){
				sLocationX = 10;
				sLocationY = 110;
				Inventory.slot[4] = true;
				IronIngot.slot = 5;
			}
			else if(!Inventory.slot[5] || slot == 6){
				sLocationX = 10;
				sLocationY = 125;
				Inventory.slot[5] = true;
				IronIngot.slot = 6;
			}
		}
		else if(IronIngot.amount <= 0){
			if(slot > 0){
				Inventory.slot[slot - 1] = false;
				slot = 0;
			}
		}
	}
}
