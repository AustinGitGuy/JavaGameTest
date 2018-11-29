package tk.swimmerwoad.CamelGame;

import tk.swimmerwoad.CamelGame.entity.mob.Player;

public class Thread4 extends Thread {
	
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
			update();
		}
	}

	private void update() {
		if(Player.MoveStat >= 100 && Player.MoveStat < 200){
				Player.MoveLevel = 2;
		}
		else if(Player.MoveStat >= 200 && Player.MoveStat < 300){
			Player.MoveLevel = 3;
	    }
		if(Player.BashStat >= 100 && Player.BashStat < 20){
				Player.BashLevel = 2;
		}
	}
}
