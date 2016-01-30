package uk.me.webpigeon.jams.jam2016.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uk.me.webpigeon.jams.jam2016.model.Direction;
import uk.me.webpigeon.jams.jam2016.model.GridWorld;
import uk.me.webpigeon.jams.jam2016.model.Vector2D;

public class AICar  extends Entity{
	
	public AICar(Vector2D location){
		this.location = location;
	}
	
	@Override
	public void update(GridWorld world){
		Vector2D nextPos = location.add(facing.getVector());
		Vector2D leftPos = location.add(facing.getVector().rotate90());
		Vector2D rightPos = location.add(facing.getVector().rotate90().rotate90().rotate90());
		Vector2D backPos = location.add(facing.getVector().rotate90().rotate90());
		
		List<Vector2D> viablePlaces = new ArrayList<Vector2D>();
		if(world.isRoadType(nextPos)) viablePlaces.add(nextPos);
		if(world.isRoadType(leftPos)) viablePlaces.add(leftPos);
		if(world.isRoadType(rightPos)) viablePlaces.add(rightPos);
		
		if(viablePlaces.isEmpty()){
			location = backPos;
		}else{
			Random random = new Random();
			location = viablePlaces.get(random.nextInt(viablePlaces.size()));
		}
		
		if(location == leftPos) facing = facing.getLeftDirection();
		if(location == rightPos) facing = facing.getRightDirection();
		if(location == backPos) facing = facing.getBackDirection();		
	}
}
