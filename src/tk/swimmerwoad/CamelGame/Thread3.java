package tk.swimmerwoad.CamelGame;

import tk.swimmerwoad.CamelGame.entity.mob.Player;

public class Thread3 extends Thread {

	private float curve;
	private float curve2 = 1;
	
	@SuppressWarnings("unused")
	public void run() {
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
			curve();
			update();
		}
	}

	private void update() {
		if(Player.pXp == curve){
			Player.pLevel++;
			if(curve2 == Player.pLevel - 1) curve2++;
		}
		else if(Player.pXp == curve){
			Player.pLevel++;
			if(curve2 == Player.pLevel - 1) curve2++;
		}
		else if(Player.pXp == curve){
			Player.pLevel++;
			if(curve2 == Player.pLevel - 1) curve2++;
		}
		else if(Player.pXp == curve){
			Player.pLevel++;
			if(curve2 == Player.pLevel - 1) curve2++;
		}
		else if(Player.pXp == curve){
			Player.pLevel++;
			if(curve2 == Player.pLevel - 1) curve2++;
		}
		else if(Player.pXp == curve){
			Player.pLevel++;
			if(curve2 == Player.pLevel - 1) curve2++;
		}
		else if(Player.pXp == curve){
			Player.pLevel++;
			if(curve2 == Player.pLevel - 1) curve2++;
		}
		else if(Player.pXp == curve){
			Player.pLevel++;
			if(curve2 == Player.pLevel - 1) curve2++;
		}
		else if(Player.pXp == curve){
			Player.pLevel++;
			if(curve2 == Player.pLevel - 1) curve2++;
		}
	}
	
	private void curve() {
		curve = (curve2 * 10);
	}
}
