package uk.me.webpigeon.jams.jam2016.model.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import uk.me.webpigeon.jams.jam2016.model.Action;
import uk.me.webpigeon.jams.jam2016.model.ActionStack;
import uk.me.webpigeon.jams.jam2016.model.GridWorld;

public class PlayerCar extends Entity {
	private ActionStack actions;
	
	public PlayerCar(ActionStack stack) {
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
		int padx = 4;
		
		g.setColor(Color.BLUE);
		g.fillRect(location.getX()*32+padx, location.getY()*32, 32-(padx*2), 32);
	}
	
	

}
