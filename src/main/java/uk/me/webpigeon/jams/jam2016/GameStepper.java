package uk.me.webpigeon.jams.jam2016;

import uk.me.webpigeon.jams.jam2016.model.ActionStack;
import uk.me.webpigeon.jams.jam2016.model.World;

public class GameStepper implements Runnable {
	private ActionStack stack;
	private World world;
	
	public GameStepper(World world, ActionStack stack) {
		this.stack = stack;
		this.world = world;
	}
	
	
	public void doTick() {
		System.out.println("tick");
		world.update();
	}

	public void run() {
		while(world.isGameOver()) {
			doTick();
		}
		
		
	}

}
