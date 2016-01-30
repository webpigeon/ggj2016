package uk.me.webpigeon.jams.jam2016.model;

import uk.me.webpigeon.jams.jam2016.model.entities.Entity;

public class RotateAction extends AbstractAction {

	public RotateAction() {
		super("Turn Right");
	}

	public void apply(GridWorld world, Entity entity) {
		Direction current = entity.getFacing();
		Direction next = current.getRightDirection();
		entity.setFacing(next);
	}

}
