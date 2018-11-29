package tk.swimmerwoad.CamelGame;

import tk.swimmerwoad.CamelGame.entity.mob.Skeleton;

public class Thread2 extends Thread {
	
	public Thread2(){
		
	}
	
	@SuppressWarnings("unused")
	public void run(){
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
		if(Skeleton.dead){
			Skeleton.respawn();
		}
	}
}
