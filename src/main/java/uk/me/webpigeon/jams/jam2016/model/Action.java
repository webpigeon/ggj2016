package uk.me.webpigeon.jams.jam2016.model;

import uk.me.webpigeon.jams.jam2016.model.entities.Entity;

public interface Action {

	public void apply(World world, Entity entity);

	public String getName();
	
}
