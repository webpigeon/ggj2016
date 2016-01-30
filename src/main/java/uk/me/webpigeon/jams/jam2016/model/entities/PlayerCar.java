package uk.me.webpigeon.jams.jam2016.model.entities;

import uk.me.webpigeon.jams.jam2016.model.Action;
import uk.me.webpigeon.jams.jam2016.model.ActionStack;

public class PlayerCar extends Entity {
	private ActionStack actions;
	
	public PlayerCar(ActionStack stack) {
		this.actions = stack;
	}

	@Override
	public void update() {
		super.update();
		
		Action action = actions.nextAction();
		action.apply(null, this);
	}
	
	
	

}
