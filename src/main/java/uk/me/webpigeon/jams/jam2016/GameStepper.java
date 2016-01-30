package uk.me.webpigeon.jams.jam2016;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import uk.me.webpigeon.jams.jam2016.model.ActionStack;
import uk.me.webpigeon.jams.jam2016.model.GridWorld;
import uk.me.webpigeon.jams.jam2016.model.World;

public class GameStepper implements Runnable {
	private ActionStack stack;
	private World world;
	private JFrame frame;
	private Thread thread;
	private JList list;
	private boolean interactive;

	private int totalActions;
	private int currLevel;
	private String levels[] = { "simple", "large" };

	public GameStepper(JFrame frame, World world, ActionStack stack) {
		this.stack = stack;
		this.world = world;
		this.frame = frame;
		this.totalActions = 0;
		this.currLevel = 0;
	}

	public void doTick() {
		System.out.println("tick");
		world.update();
	}

	public void run() {
		if (!interactive) {
			stack.lock();
		}

		try {
			int chainActions = 0;
			while (stack.hasMoreActions() || interactive) {
				if (list != null)
					list.setSelectedIndex(stack.getCurrentAction());
				chainActions++;
				totalActions++;
				doTick();
				Thread.sleep(1000);
			}

			// calculate score
			int score = 0;
			if (chainActions < 3) {
				score = chainActions;
			} else {
				score = chainActions + (chainActions - 3);
			}
			world.addScore(score);

		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} catch (RuntimeException ex) {
			JOptionPane.showMessageDialog(frame, ex.getMessage());
			world.updateGlobalScore(-10);
			stack.unlock();
			return;
		}

		if (world.hasPlayerWon()) {
			int bonus = (world.getPar() - totalActions) * 4;
			int levelScore = world.getLevelScore() + bonus;
			world.updateGlobalScore(levelScore);

			JOptionPane.showMessageDialog(frame, "You win: " + levelScore);
			loadWorld();
		}

		if (!interactive) {
			stack.unlock();
		}
	}
	
	public void loadWorld() {
		stack.unlock();
		
		GridWorld nextWorld = MapLoader.loadWorld(levels[currLevel++]);
		MapLoader.buildWorld(nextWorld, stack);
		world.setWorld(nextWorld);
		stack.clear();
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

	public void setList(JList list) {
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
