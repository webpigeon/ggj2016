package uk.me.webpigeon.jams.jam2016.model;


import uk.me.webpigeon.jams.jam2016.model.entities.Entity;

public class ForwardAction extends AbstractAction {

	public ForwardAction() {
		super("Forwards");
	}
	
	@Override
	public void apply(GridWorld world, Entity entity) {
		Vector2D currentPos = entity.getPosition();
		Direction direction = entity.getFacing();
		
		currentPos = currentPos.add(direction.getVector());
		entity.setPosition(currentPos);
	}

}
