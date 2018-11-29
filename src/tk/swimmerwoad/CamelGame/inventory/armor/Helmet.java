package tk.swimmerwoad.CamelGame.inventory.armor;

public abstract class Helmet {
	
	private String material;
	private boolean equip = false;
	public static int amount;
	private int price; //Price in gold
	private int pProt; //Amount physically protected
	private int mProt; //Amount magically protected
	public int slot;
	public static int sLocationX;
	public static int sLocationY;
	public static int oLocationX;
	public static int oLocationY;
	
	public Helmet(){
		
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
		
	}

	
}
