package uk.me.webpigeon.jams.jam2016.model.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import uk.me.webpigeon.jams.jam2016.model.Action;
import uk.me.webpigeon.jams.jam2016.model.ActionStack;
import uk.me.webpigeon.jams.jam2016.model.GridWorld;
import uk.me.webpigeon.jams.jam2016.model.Vector2D;

public class PlayerCar extends Entity {
	private ActionStack actions;
	
	public PlayerCar(int x, int y, ActionStack stack) {
		super();
		this.location = new Vector2D(x,y);
		this.actions = stack;
	}

	@Override
	public void update(GridWorld world) {
		super.update(world);
		
		Action action = actions.nextAction();
		action.apply(world, this);
	}
	
	@Override
	public void draw(Graphics2D g) {
		double degrees = (facing.ordinal() * Math.PI) / 2;
		
		g.translate(location.getX()*32, location.getY()*32);
		g.rotate(degrees);
		
		int padx = 4;
		
		g.setColor(Color.BLUE);
		g.fillRect(-16+padx, -16, 32-(padx*2), 32);
		
		g.rotate(-degrees);
		g.translate(-location.getX()*32, -location.getY()*32);
	}
	
	

}
