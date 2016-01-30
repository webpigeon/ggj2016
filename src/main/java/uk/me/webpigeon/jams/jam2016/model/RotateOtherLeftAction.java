package uk.me.webpigeon.jams.jam2016.model;

import uk.me.webpigeon.jams.jam2016.model.entities.Entity;

public class RotateOtherLeftAction extends AbstractAction {

	public RotateOtherLeftAction() {
		super("Turn Left");
	}

	public void apply(GridWorld world, Entity entity) {
		Direction current = entity.getFacing();
		Direction next = current.getLeftDirection();
		
		entity.setFacing(next);
	}

}
