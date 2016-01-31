package uk.me.webpigeon.jams.jam2016.model.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import uk.me.webpigeon.jams.jam2016.model.GridWorld;
import uk.me.webpigeon.jams.jam2016.model.ImageGallery;
import uk.me.webpigeon.jams.jam2016.model.Vector2D;
import uk.me.webpigeon.jams.jam2016.model.World;

/**
 * A traffic light:
 * 
 * When light is red, take heed
 * When light is green - go with speed
 * when light is broken - do whatever.
 * 
 * @author piers
 *
 */
public class TrafficLight extends Entity{
	
	private boolean active;
	private int activeTime, nonActiveTime;
	private int current;
	
	public TrafficLight(Vector2D location, int activeTime, int nonActiveTime){
		this(location, false, activeTime, nonActiveTime);
	}
	
	public TrafficLight(Vector2D location, boolean active, int activeTime, int nonActiveTime) {
		this.location = location;
		this.activeTime = activeTime;
		this.nonActiveTime = nonActiveTime;
		this.active = active;
	}

	@Override
	public void update(GridWorld world){
		current++;
		if(active){
			if(current > activeTime){
				active = false;
				current = 0;
			}
		}else{
			if(current > nonActiveTime){
				active = true;
				current = 0;
			}
		}
	}
	
	@Override
	public void draw(Graphics2D g, ImageGallery ig){
		g.setColor(active ? Color.RED : Color.GREEN);
		g.fillOval(
				location.getX() * World.TILE_SIZE,
				location.getY() * World.TILE_SIZE,
				World.TILE_SIZE,
				World.TILE_SIZE
				);
		g.setColor(active ? Color.GREEN : Color.RED);
		int timeRemaining = (active)? activeTime - current : nonActiveTime - current;
		g.drawString("" + timeRemaining,
				location.getX() * World.TILE_SIZE + (World.TILE_SIZE / 2),
				location.getY() * World.TILE_SIZE + (World.TILE_SIZE / 2));
	}
	
	public boolean isActive(){
		return active;
	}
	
	@Override
	public String toString(){
		return "TrafficLight: Active: " + active;
	}

}
