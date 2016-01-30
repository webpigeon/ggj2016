package uk.me.webpigeon.jams.jam2016.model;

import java.awt.Color;
import java.awt.Graphics2D;

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
	
	/**
	 * Do the update for the world - Game loop can call this
	 */
	public void update(){
		//TODO Do this
	}
	
	/**
	 * Do the drawing for the world - Game loop can call this
	 * @param graphics
	 */
	public void draw(Graphics2D graphics){
		//TODO Do this as well
		graphics.setColor(Color.RED);
		graphics.drawString("Strawberry", 50, 50);
	}

	public boolean isGameOver() {
		return false;
	}

}
