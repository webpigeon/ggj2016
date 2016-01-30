package uk.me.webpigeon.jams.jam2016.model;

import java.awt.Color;
import java.awt.Dimension;
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
	public static final Integer TILE_SIZE = 64;
	
	// Contains the grid itself
	private GridWorld gridWorld;
	
	public World(GridWorld gridWorld){
		this.gridWorld = gridWorld;
		this.setPreferredSize(new Dimension(gridWorld.getWidth()*TILE_SIZE, gridWorld.getHeight()*TILE_SIZE));
	}
	
	public boolean hasPlayerWon() {
		return gridWorld.hasWon();
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
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		
		Graphics2D g2 = (Graphics2D)graphics;
		gridWorld.render(g2);
	}

	public void addScore(int score) {
		this.gridWorld.addScore(score);
	}

	public int getScore() {
		return gridWorld.getScore();
	}

	public void setWorld(GridWorld nextWorld) {
		gridWorld = nextWorld;
		repaint();
	}

}
