package uk.me.webpigeon.jams.jam2016.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

/**
 * This is the world object.
 * 
 * It contains everything
 * 
 * Including the world object ...
 * 
 * Don't think too hard about that one
 * @author piers
 *
 */
public class World extends JComponent{
	
	// Contains the grid itself
	private GridWorld gridWorld;
	
	public World(GridWorld gridWorld){
		this.gridWorld = gridWorld;
	}
	
	public boolean hasPlayerWon() {
		return gridWorld.getScore() == 1;
	}
	
	/**
	 * Do the update for the world - Game loop can call this
	 */
	public void update(){
		System.out.println("Starting update loop");
		gridWorld.update();
		repaint();
	}
	
	/**
	 * Do the drawing for the world - Game loop can call this
	 * @param graphics
	 */
	
	@Override
	public void paintComponent(Graphics graphics){
		graphics.setColor(Color.RED);
		graphics.drawString("Strawberry", 50, 50);
		
		Graphics2D g2 = (Graphics2D)graphics;
		gridWorld.render(g2);
	}

}
