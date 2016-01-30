package uk.me.webpigeon.jams.jam2016.model.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uk.me.webpigeon.jams.jam2016.model.Direction;
import uk.me.webpigeon.jams.jam2016.model.GridWorld;
import uk.me.webpigeon.jams.jam2016.model.Vector2D;

public class AICar  extends Entity{
	
	public AICar(Vector2D location){
		this.location = location;
	}
	
	@Override
	public void update(GridWorld world){
		
		Vector2D nextPos = location.add(facing.getVector());
		if (world.isViable(nextPos)) {
			System.out.println(world.isViable(nextPos));
			location = nextPos;
			return;
		}
		
		Vector2D rightPos = location.add(facing.getRightDirection().getVector());
		Vector2D leftPos = location.add(facing.getLeftDirection().getVector());
		
		if (world.isViable(leftPos)) {
			System.out.println(world.isViable(leftPos));
			facing = facing.getLeftDirection();
			return;
		} 
		
		if (world.isViable(rightPos)) {
			System.out.println(world.isViable(rightPos));
			facing = facing.getRightDirection();
			return;
		} 	
	}
	
	@Override
	public void draw(Graphics2D g) {
		double degrees = (facing.ordinal() * Math.PI) / 2;
		
		g.setColor(Color.ORANGE);
		g.drawRect(location.getX()*32, location.getY()*32, 32, 32);
		
		g.translate(location.getX()*32+16, location.getY()*32+16);
		g.rotate(degrees);
		
		int padx = 4;
		
		g.setColor(Color.ORANGE);
		g.fillRect(-16+padx, -16, 32-(padx*2), 32);
		
		g.setColor(Color.CYAN);
		g.fillRect(-16+padx, -13, 32-(padx*2), 16);
		
		g.rotate(-degrees);
		g.translate(-location.getX()*32-16, -location.getY()*32-16);
	}
}
