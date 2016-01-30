package uk.me.webpigeon.jams.jam2016;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import uk.me.webpigeon.jams.jam2016.model.ActionStack;
import uk.me.webpigeon.jams.jam2016.model.World;

public class GameStepper implements Runnable {
	private ActionStack stack;
	private World world;
	private JFrame frame;
	private Thread thread;
	private JList list;
	private boolean interactive;
	
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
		int score = 0;
		
		if (!interactive) {
			stack.lock();
		}
		
		try {			
			int numActions = 0;
			while( stack.hasMoreActions() || interactive ) {
				if(list != null) list.setSelectedIndex(stack.getCurrentAction());
				numActions++;
				doTick();
				Thread.sleep(1000);
			}
			
			score = numActions + numActions/4;
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} catch (RuntimeException ex) {
			JOptionPane.showMessageDialog(frame, ex.getMessage());
		}
		
		if (world.hasPlayerWon()) {
			JOptionPane.showMessageDialog(frame, "You win: "+score);
		}
		
		if (!interactive) {
			stack.unlock();
		}
	}

	public void runSimulation() {
		if (thread == null || !thread.isAlive()) {
			setInteractive(false);
			thread = new Thread(this);
			thread.start();
		}
	}


	public void reset() {
		stack.clear();
	}
	
	public void setList(JList list){
		this.list = list;
	}


	public void runInteractive() {
		if (thread == null || !thread.isAlive()) {
			setInteractive(true);
			thread = new Thread(this);
			thread.start();
		}
	}


	private void setInteractive(boolean b) {
		this.interactive = b;
	}

}
