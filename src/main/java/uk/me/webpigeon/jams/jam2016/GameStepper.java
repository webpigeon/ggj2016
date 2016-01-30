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
			int i = 0;
			while(!world.isGameOver() && stack.hasMoreActions() ) {
				if(list != null) list.setSelectedIndex(i++);
				doTick();
				Thread.sleep(1000);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} catch (RuntimeException ex) {
			JOptionPane.showMessageDialog(frame, ex.getMessage());
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
	
	public void setList(JList list){
		this.list = list;
	}

}
