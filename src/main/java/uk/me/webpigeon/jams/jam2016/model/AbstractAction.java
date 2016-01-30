package uk.me.webpigeon.jams.jam2016.model;

import uk.me.webpigeon.jams.jam2016.model.entities.Entity;

public class AbstractAction implements Action {
	private final String name;
	
	public AbstractAction(String name) {
		this.name = name;
	}

	public void apply(GridWorld world, Entity entity) {
		
	}
	
	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

}
