package uk.me.webpigeon.jams.jam2016.model.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Collection;

import uk.me.webpigeon.jams.jam2016.model.Action;
import uk.me.webpigeon.jams.jam2016.model.ActionStack;
import uk.me.webpigeon.jams.jam2016.model.GridWorld;
import uk.me.webpigeon.jams.jam2016.model.Vector2D;
import uk.me.webpigeon.jams.jam2016.model.World;

public class PlayerCar extends Entity {
	private ActionStack actions;
	
	public PlayerCar(int x, int y, ActionStack stack) {
		super();
		this.location = new Vector2D(x,y);
		this.actions = stack;
	}

	@Override
	public void update(GridWorld world) {
		super.update(world);
		
		if (actions.hasMoreActions()) {
			Action action = actions.nextAction();
			action.apply(world, this);
			
			int typeType = world.getTileType(location.getX(), location.getY());
			if (typeType == 2) {
				world.incrementScore();
			}
			
			Collection<Entity> entities = world.getEntityAt(location.getX(), location.getY());
			for (Entity entity : entities) {
				if (entity.isGoal()) {
					world.incrementScore();
				}
			}
			
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		double degrees = (facing.ordinal() * Math.PI) / 2;
		
		int graphicalX = location.getX() * World.TILE_SIZE;
		int graphicalY = location.getY() * World.TILE_SIZE;
		int halfSize = World.TILE_SIZE/2;
		
		g.setColor(Color.BLUE);
		g.drawRect(graphicalX, graphicalY, World.TILE_SIZE, World.TILE_SIZE);
		
		g.translate(graphicalX+halfSize, graphicalY+halfSize);
		g.rotate(degrees);
		
		int padx = 4;
		
		g.setColor(Color.BLUE);
		g.fillRect(-halfSize+padx, -halfSize, World.TILE_SIZE-(padx*2),World.TILE_SIZE);
		
		g.setColor(Color.CYAN);
		g.fillRect(-16+padx, -13, 32-(padx*2), 16);
		
		g.rotate(-degrees);
		g.translate(-graphicalX-halfSize, -graphicalY-halfSize);
	}
	
	

}
