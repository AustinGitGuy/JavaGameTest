package tk.swimmerwoad.CamelGame;

import tk.swimmerwoad.CamelGame.casino.SlotMachine;

public class Thread7 implements Runnable {
	
	private SlotMachine slots = new SlotMachine();
	
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
		slots.update();
	}

}