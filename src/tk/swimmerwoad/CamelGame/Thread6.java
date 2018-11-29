package tk.swimmerwoad.CamelGame;


import tk.swimmerwoad.CamelGame.entity.mob.Player;
import tk.swimmerwoad.CamelGame.input.SprintKey;

public class Thread6 implements Runnable{

	public SprintKey skey = new SprintKey();
	
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
			render();
			fps++;
		}
	}

	private void render() {
		
	}

	private void update() {
		if(skey.sprint){
			if(Player.stamina > 0){
				Player.speed = 2;
				Player.stamina--;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				Player.speed = Player.tempSpeed;
			}
		}
	}

}
