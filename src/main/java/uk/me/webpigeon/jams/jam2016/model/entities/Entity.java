package uk.me.webpigeon.jams.jam2016.model.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import uk.me.webpigeon.jams.jam2016.model.Direction;

/**
 * This is an entity
 * 
 * It is named Bob
 * @author piers
 *
 */
public class Entity {
	// Location in grid co-ordinates
	protected Point location;
	protected Direction facing;
	
	public Entity() {
		this.location = new Point(0,0);
		this.facing = Direction.NORTH;
	}

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
		graphics.fillOval(5, 5, 100, 100);
	}

	public Point getPosition() {
		return new Point(location);
	}

	public Direction getFacing() {
		return facing;
	}
}
