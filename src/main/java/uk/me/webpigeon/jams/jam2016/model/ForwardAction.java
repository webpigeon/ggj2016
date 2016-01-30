package uk.me.webpigeon.jams.jam2016.model;

import java.awt.Point;

import uk.me.webpigeon.jams.jam2016.model.entities.Entity;

public class ForwardAction extends AbstractAction {

	public ForwardAction() {
		super("Forwards");
	}
	
	@Override
	public void apply(World world, Entity entity) {
		Vector2D currentPos = entity.getPosition();
//		Vector2D facing = entity.getFacing();
		
//		switch(facing) {
//			case NORTH:
//				currentPos.y -= 1;
//				break;
//			case SOUTH:
//				currentPos.y += 1;
//				break;
//			case EAST:
//				currentPos.x += 1;
//				break;
//			case WEST:
//				currentPos.x -= 1;
//				break;
//		}
	}

}
