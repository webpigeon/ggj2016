package uk.me.webpigeon.jams.jam2016.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

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
public class World {
	
	// Contains the grid itself
	private GridWorld gridWorld;
	
	private List<Entity> entities = new ArrayList<Entity>();
	
	public World(GridWorld gridWorld){
		this.gridWorld = gridWorld;
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
	public void draw(Graphics2D graphics){
		graphics.setColor(Color.RED);
		graphics.drawString("Strawberry", 50, 50);
		
		for(Entity entity : entities){
			entity.draw(graphics);
		}
	}

}
