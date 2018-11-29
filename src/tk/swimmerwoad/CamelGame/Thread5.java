package tk.swimmerwoad.CamelGame;

import tk.swimmerwoad.CamelGame.dialogue.HouseManagerTalk;
import tk.swimmerwoad.CamelGame.house.HouseKey;
import tk.swimmerwoad.CamelGame.house.furniture.Table;

public class Thread5 extends Thread {

	private HouseKey input;
	
	@SuppressWarnings("unused")
	public void run() {
		input(Game.housekey);
		Long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int fps = 0;
		int updates = 0;
		while(Game.running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				update();
				updates++;
				delta--;
			}
			fps++;
			update();
		}
	}
	
	public void input(HouseKey input){
		this.input = input;
	}
	
	private void update() {
		if(input.table && HouseManagerTalk.table >= 1){
			if(Game.state == Game.State.Edit){
				Table.tableCount++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Table.tableCount);
				tableMove();
			}
		}
	}
	
	public void tableMove(){
		if(Table.tableCount == 1){
			while(true){
				System.out.println("Start Test\n");
				if(input.up){
					Table.t1y--;
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if(input.down){
					Table.t1y++;
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if(input.left){
					Table.t1x--;
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if(input.right){
					Table.t1x++;
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(input.close){
					System.out.println("Close Test\n");
					System.out.println("Table X: " + Table.t1x + "\n");
					System.out.println("Table Y: " + Table.t1y + "\n");
					break;
				}
			}	
		}
	}


}
