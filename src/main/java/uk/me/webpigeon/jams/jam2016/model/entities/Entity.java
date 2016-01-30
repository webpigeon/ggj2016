package uk.me.webpigeon.jams.jam2016.model.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import uk.me.webpigeon.jams.jam2016.model.Vector2D;

/**
 * This is an entity
 * 
 * It is named Bob
 * @author piers
 *
 */
public class Entity {
	
	// Location in grid co-ordinates
	protected Vector2D location;

	/**
	 * This is the update function
	 */
	public void update(){
		
	}
	
	/**
	 * This is the draw function
	 * @param graphics
	 */
	public void draw(Graphics2D graphics){
		graphics.setColor(Color.GREEN);
		graphics.fillOval(location.getX() - 5, location.getY() - 5, 10, 10);
	}
}
