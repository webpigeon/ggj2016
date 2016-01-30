package uk.me.webpigeon.jams.jam2016;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uk.me.webpigeon.jams.jam2016.model.ActionStack;
import uk.me.webpigeon.jams.jam2016.model.World;

public class GameStepper implements Runnable {
	private ActionStack stack;
	private World world;
	private JFrame frame;
	private Thread thread;
	
	public GameStepper(JFrame frame, World world, ActionStack stack) {
		this.stack = stack;
		this.world = world;
		this.frame = frame;
	}
	
	
	public void doTick() {
		System.out.println("tick");
		world.update();
	}

	public void run() {
		try {
			while(stack.hasMoreActions() ) {
				doTick();
				Thread.sleep(1000);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} catch (RuntimeException ex) {
			JOptionPane.showMessageDialog(frame, ex.getMessage());
		}
		
		if (world.hasPlayerWon()) {
			JOptionPane.showMessageDialog(frame, "You win");
		} else {
			//JOptionPane.showMessageDialog(frame, "You lose");
		}
		
	}

	public void runSimulation() {
		if (thread == null || !thread.isAlive()) {
			thread = new Thread(this);
			thread.start();
		}
	}


	public void reset() {
		stack.clear();
	}

}
