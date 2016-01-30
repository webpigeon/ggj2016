package uk.me.webpigeon.jams.jam2016.model.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Collection;

import uk.me.webpigeon.jams.jam2016.model.Direction;
import uk.me.webpigeon.jams.jam2016.model.GridWorld;
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

	protected Direction facing;
	
	public Entity() {
		this.location = new Vector2D(0,0);
		this.facing = Direction.NORTH;
	}

	/**
	 * This is the update function
	 */
	public void update(GridWorld world){
		
		Collection<Entity> entities = world.getEntityAt(location.getX(), location.getY());
		for (Entity entity : entities) {
			if (!entity.equals(this)) {
				throw new RuntimeException("Crash!");
			}
		}
		
	}
	
	/**
	 * This is the draw function
	 * @param graphics
	 */
	public void draw(Graphics2D graphics){
		graphics.setColor(Color.ORANGE);
		graphics.fillRect(location.getX() * 32, location.getY() * 32, 32, 32);
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

	public void setFacing(Direction direction) {
		this.facing = direction;
	}

	public boolean isAt(int x, int y) {
		return location.getX() == x && location.getY() == y;
	}

	public boolean isGoal() {
		return false;
	}
}
