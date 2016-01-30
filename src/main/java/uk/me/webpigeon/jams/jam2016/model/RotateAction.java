package uk.me.webpigeon.jams.jam2016.model;

import uk.me.webpigeon.jams.jam2016.model.entities.Entity;

public class RotateAction extends AbstractAction {

	public RotateAction() {
		super("Rotate");
	}

	public void apply(GridWorld world, Entity entity) {
		Direction current = entity.getFacing();
		
		int currID = current.ordinal();
		currID += 1;
		currID %= Direction.values().length;
		
		entity.setFacing(Direction.values()[currID]);
	}

}
