package uk.me.webpigeon.jams.jam2016.model.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import uk.me.webpigeon.jams.jam2016.model.Direction;
import uk.me.webpigeon.jams.jam2016.model.GridWorld;
import uk.me.webpigeon.jams.jam2016.model.Vector2D;
import uk.me.webpigeon.jams.jam2016.model.World;

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

	protected Direction facing;
	
	public Entity() {
		this.location = new Vector2D(0,0);
		this.facing = Direction.NORTH;
	}

	/**
	 * This is the update function
	 */
	public void update(GridWorld world){
		
	}
	
	/**
	 * This is the draw function
	 * @param graphics
	 */
	public void draw(Graphics2D graphics){
		graphics.setColor(Color.GREEN);
		graphics.fillOval(location.getX() - 5, location.getY() - 5, 10, 10);
	}

	public Vector2D getPosition() {
		return location;
	}

	public Direction getFacing() {
		return facing;
	}

	public void setPosition(Vector2D location) {
		this.location = location;
	}
}
