package tk.swimmerwoad.CamelGame.inventory.armor;

import tk.swimmerwoad.CamelGame.inventory.Inventory;

public class WoodenHelm extends Helmet {
	
	private String material = "Wooden";
	private boolean equip = false;
	public static int amount = 1;
	private int price; //Price in gold
	private int pProt; //Amount physically protected
	private int mProt; //Amount magically protected
	public static int slot;
	public static int sLocationX;
	public static int sLocationY;
	public int oLocationX;
	public int oLocationY;
	
	public WoodenHelm(){
		
	}
	
	public String getMat(){
		return material;
	}
	
	public int getPrice(){
		return price;
	}
	
	public int getPProt(){
		return pProt;
	}
	
	public int getMProt(){
		return mProt;
	}
	
	public boolean getEquip(){
		return equip;
	}
	
	public void update(){
		if(amount >= 1){
			if(!Inventory.slot[0] || slot == 1){
				sLocationX = 10;
				sLocationY = 50;
				oLocationX = 20;
				oLocationY = 20;
				Inventory.slot[0] = true;
				slot = 1;
			}
			else if(!Inventory.slot[1] || slot == 2){
				sLocationX = 10;
				sLocationY = 65;
				oLocationX = 25;
				oLocationY = 85;
				Inventory.slot[1] = true;
				slot = 2;
			}
			else if(!Inventory.slot[2] || slot == 3){
				sLocationX = 10;
				sLocationY = 80;
				oLocationX = 25;
				oLocationY = 150;
				Inventory.slot[2] = true;
				slot = 3;
			}
			else if(!Inventory.slot[3] || slot == 4){
				sLocationX = 10;
				sLocationY = 95;
				Inventory.slot[3] = true;
				slot = 4;
			}
			else if(!Inventory.slot[4] || slot == 5){
				sLocationX = 10;
				sLocationY = 110;
				Inventory.slot[4] = true;
				slot = 5;
			}
			else if(!Inventory.slot[5] || slot == 6){
				sLocationX = 10;
				sLocationY = 125;
				Inventory.slot[5] = true;
				slot = 6;
			}
		}
		else if(amount <= 0){
			if(slot > 0){
				Inventory.slot[slot - 1] = false;
				slot = 0;
			}
		}
	}
}
