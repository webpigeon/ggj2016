package uk.me.webpigeon.jams.jam2016.model;

import uk.me.webpigeon.jams.jam2016.model.entities.Entity;

public class ForwardAction extends AbstractAction {

	public ForwardAction() {
		super("Forwards");
	}

	public void apply(GridWorld world, Entity entity) {
		Vector2D currentPos = entity.getPosition();
		Direction direction = entity.getFacing();
		currentPos = currentPos.add(direction.getVector());

		if (world.isRoadType(currentPos.getX(), currentPos.getY())) {
			entity.setPosition(currentPos);
		} else {
			throw new RuntimeException("You're now offroad (and voided warrenty) " + currentPos);
		}
	}

}
