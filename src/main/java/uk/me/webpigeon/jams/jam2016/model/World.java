package uk.me.webpigeon.jams.jam2016.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import uk.me.webpigeon.jams.jam2016.GridRenderer;
import uk.me.webpigeon.jams.jam2016.model.entities.Entity;

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
	private GridRenderer gridRenderer;
	
	private List<Entity> entities = new ArrayList<Entity>();
	
	public World(GridWorld gridWorld){
		this.gridWorld = gridWorld;
		gridRenderer = new GridRenderer(gridWorld);
	}
	
	/**
	 * Do the update for the world - Game loop can call this
	 */
	public void update(){
		System.out.println("Starting update loop");
		for(Entity entity : entities){
			entity.update();
		}
	}
	
	/**
	 * Do the drawing for the world - Game loop can call this
	 * @param graphics
	 */
	
	@Override
	public void paintComponent(Graphics graphics){
		gridRenderer.draw(graphics);
		graphics.setColor(Color.RED);
		graphics.drawString("Strawberry", 50, 50);
		
		for(Entity entity : entities){
			entity.draw((Graphics2D)graphics);
		}
	}

}
